package io.github.linxiaobaixcg.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.github.linxiaobaixcg.entity.User;
import io.github.linxiaobaixcg.entity.vo.UpdateCountVO;
import io.github.linxiaobaixcg.entity.vo.UserRegisterVO;
import io.github.linxiaobaixcg.exception.BadRequestException;
import io.github.linxiaobaixcg.mapper.UserMapper;
import io.github.linxiaobaixcg.utils.IdWorker;
import io.github.linxiaobaixcg.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2020-01-06 22:27
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return
     */
    public User findUserById(Long id) {
        User user = userMapper.selectById(id);
        user.setPassword(null);
        return user;
    }

    /**
     * 用户注册
     *
     * @param userRegisterVO
     */
    @Transactional
    public void register(UserRegisterVO userRegisterVO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", userRegisterVO.getPhone());
        User user = userMapper.selectOne(queryWrapper);
        if (user != null) {
            throw new BadRequestException("手机号码已存在！");
        }
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", userRegisterVO.getUsername());
        User checkUser = userMapper.selectOne(userQueryWrapper);
        if (checkUser != null) {
            throw new BadRequestException("用户名已存在！");
        }
        if (userRegisterVO != null && !userRegisterVO.getPassword().equals(userRegisterVO.getCheckPassword())) {
            throw new BadRequestException("密码不一致！");
        }
        User saveUser = new User();
        saveUser.setId(idWorker.nextId());
        saveUser.setUsername(userRegisterVO.getUsername());
        saveUser.setPassword(bCryptPasswordEncoder.encode(userRegisterVO.getPassword()));
        saveUser.setLastPasswordResetTime(new Timestamp(System.currentTimeMillis()));
        saveUser.setPhone(userRegisterVO.getPhone());
        saveUser.setAvatar("https://i.loli.net/2019/04/04/5ca5b971e1548.jpeg");
        saveUser.setStatus(0);
        saveUser.setAnswerCount(0);
        saveUser.setFansCount(0);
        saveUser.setFollowCount(0);
        saveUser.setProblemCount(0);
        userMapper.insert(saveUser);
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    public String login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", user.getPhone());
        User checkUser = userMapper.selectOne(queryWrapper);
        if (checkUser == null) {
            throw new BadRequestException("该用户不存在！");
        }
        if (checkUser.getStatus() == 1) {
            throw new BadRequestException("该用户已被禁止使用！");
        }
        if (!bCryptPasswordEncoder.matches(user.getPassword(), checkUser.getPassword())) {
            throw new BadRequestException("密码错误！");
        }
        return jwtUtils.generateToken(checkUser.getId() + "");
    }

    /**
     * 修改用户关注数
     *
     * @param userId
     * @param count
     */
    public void updateFollowCount(String userId, Integer count) {
        userMapper.updateFollowCount(userId, count);
    }

    /**
     * 修改用户粉丝数
     *
     * @param userId
     * @param count
     */
    public void updateFansCount(String userId, Integer count) {
        userMapper.updateFansCount(userId, count);
    }

    /**
     * 修改提问数
     *
     * @param userId
     * @param count
     */
    public void updateProblemCount(String userId, Integer count) {
        userMapper.updateProblemCount(userId, count);
    }

    /**
     * 修改用户回答数
     *
     * @param userId
     * @param count
     */
    public void updateAnswerCount(String userId, Integer count) {
        userMapper.updateAnswerCount(userId, count);
    }
}
