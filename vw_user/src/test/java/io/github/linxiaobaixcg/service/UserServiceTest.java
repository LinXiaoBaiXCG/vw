package io.github.linxiaobaixcg.service;

import io.github.linxiaobaixcg.entity.User;
import io.github.linxiaobaixcg.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void findUserById() {
        User user =  userService.findUserById("1");
        log.info("用户信息是：{}",user);
    }
}