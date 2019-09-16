package io.github.linxiaobaixcg.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Optional;
import io.github.linxiaobaixcg.common.exception.BadRequestException;
import io.github.linxiaobaixcg.common.exception.EntityExistException;
import io.github.linxiaobaixcg.common.util.EncryptUtils;
import io.github.linxiaobaixcg.common.util.RedisUtils;
import io.github.linxiaobaixcg.common.util.ValidationUtils;
import io.github.linxiaobaixcg.modules.app.controller.vo.UserRegisterVo;
import io.github.linxiaobaixcg.modules.app.entity.VwUser;
import io.github.linxiaobaixcg.modules.app.service.VwUserService;
import io.github.linxiaobaixcg.modules.app.repository.VwUserRepository;
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
    private RedisUtils redisUtils;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(UserRegisterVo userRegisterVo) {
        //验证验证码是否过期
        if (null == redisUtils.get(userRegisterVo.getUuid())) {
            throw new BadRequestException("验证码已过期！");
        }
        //验证验证码是否正确
        if (!userRegisterVo.getCode().equals(redisUtils.get(userRegisterVo.getUuid()))) {
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
            throw new BadRequestException("用户名已存在！");
        }
        //验证两次密码是否一致
        if (!userRegisterVo.getCheckPassword().equals(userRegisterVo.getPassword())) {
            throw new BadRequestException("密码不一致");
        }
        //执行注册
        VwUser vwUser = new VwUser();
        vwUser.setUsername(userRegisterVo.getUsername());
        vwUser.setPhone(userRegisterVo.getPhone());
        vwUser.setPassword(EncryptUtils.encryptPassword(userRegisterVo.getPassword()));
        vwUser.setAvatar("https://i.loli.net/2019/04/04/5ca5b971e1548.jpeg");
        vwUser.setStatus(0);
        vwUser.setLastPasswordResetTime(new Timestamp(System.currentTimeMillis()));
        vwUserRepository.insert(vwUser);
    }
}
