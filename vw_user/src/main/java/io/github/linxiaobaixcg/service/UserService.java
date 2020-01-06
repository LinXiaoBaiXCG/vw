package io.github.linxiaobaixcg.service;

import io.github.linxiaobaixcg.entity.User;
import io.github.linxiaobaixcg.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    public User findUserById(String id){
        return userMapper.selectById(id);
    }
}
