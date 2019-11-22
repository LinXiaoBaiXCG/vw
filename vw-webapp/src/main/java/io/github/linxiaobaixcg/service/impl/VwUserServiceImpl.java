package io.github.linxiaobaixcg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.linxiaobaixcg.exception.BadRequestException;
import io.github.linxiaobaixcg.util.RedisUtils;
import io.github.linxiaobaixcg.entity.VwAnswer;
import io.github.linxiaobaixcg.entity.VwProblem;
import io.github.linxiaobaixcg.entity.VwUser;
import io.github.linxiaobaixcg.entity.vo.UserRegisterVo;
import io.github.linxiaobaixcg.oauth2.utils.EncryptUtil;
import io.github.linxiaobaixcg.repository.VwAnswerRepository;
import io.github.linxiaobaixcg.repository.VwProblemRepository;
import io.github.linxiaobaixcg.repository.VwUserRepository;
import io.github.linxiaobaixcg.service.VwUserService;
import io.github.linxiaobaixcg.service.dto.VwUserDTO;
import io.github.linxiaobaixcg.service.mapper.VwUserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * @program: app
 * @description: VwUserServiceImpl
 * @author: LCQ
 * @create: 2019-05-20 23:28
 **/
@Service
public class VwUserServiceImpl implements VwUserService {

    @Autowired
    private VwUserRepository vwUserRepository;

    @Autowired
    private VwUserMapper vwUserMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private VwAnswerRepository vwAnswerRepository;

    @Autowired
    private VwProblemRepository vwProblemRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(UserRegisterVo userRegisterVo) {
        //验证验证码是否过期
        if (null == redisUtils.get(userRegisterVo.getUuid())) {
            throw new BadRequestException("验证码已过期！");
        }
        //验证验证码是否正确
        if (StringUtils.isBlank(userRegisterVo.getCode()) || !redisUtils.get(userRegisterVo.getUuid()).toString().equalsIgnoreCase(userRegisterVo.getCode())) {
            throw new BadRequestException("验证码错误！");
        }
        //验证手机号是否存在
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("phone", userRegisterVo.getPhone());
        if (vwUserRepository.selectOne(queryWrapper) != null) {
            throw new BadRequestException("手机号已存在，请重新输入！");
        }
        //验证用户名是否存在
        QueryWrapper checkUsername = new QueryWrapper();
        checkUsername.eq("username", userRegisterVo.getUsername());
        if (vwUserRepository.selectOne(checkUsername) != null) {
            throw new BadRequestException("用户名已存在，请重新输入！");
        }
        //验证两次密码是否一致
        if (!userRegisterVo.getCheckPassword().equals(userRegisterVo.getPassword())) {
            throw new BadRequestException("密码不一致!");
        }
        //执行注册
        VwUser vwUser = new VwUser();
        vwUser.setUsername(userRegisterVo.getUsername());
        vwUser.setPhone(userRegisterVo.getPhone());
        vwUser.setPassword(EncryptUtil.encryptPassword(userRegisterVo.getPassword()));
        vwUser.setAvatar("https://i.loli.net/2019/04/04/5ca5b971e1548.jpeg");
        vwUser.setStatus(0);
        vwUser.setLastPasswordResetTime(new Timestamp(System.currentTimeMillis()));
        vwUserRepository.insert(vwUser);
    }

    @Override
    public VwUserDTO findUserInfo(Long id) {
        //查询用户信息
        QueryWrapper<VwUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        VwUser vwUser = vwUserRepository.selectOne(queryWrapper);
        VwUserDTO vwUserDTO =  vwUserMapper.toDto(vwUser);
        //查询回答数
        QueryWrapper<VwAnswer> answerQueryWrapper = new QueryWrapper<>();
        answerQueryWrapper.eq("user_id",id);
        answerQueryWrapper.eq("is_deleted",0);
        vwUserDTO.setAnswerCount(vwAnswerRepository.selectCount(answerQueryWrapper));
        //查询提问数
        QueryWrapper<VwProblem> problemQueryWrapper = new QueryWrapper<>();
        problemQueryWrapper.eq("user_id",id);
        problemQueryWrapper.eq("is_deleted",0);
        vwUserDTO.setProblemCount(vwProblemRepository.selectCount(problemQueryWrapper));
        //TODO 查询关注的人数

        //TODO 查询关注的问题数

        return vwUserDTO;
    }

    @Override
    public void updateUserInfo(VwUser vwUser) {
        vwUserRepository.updateById(vwUser);
    }
}
