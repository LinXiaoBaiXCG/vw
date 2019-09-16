package io.github.linxiaobaixcg.modules.app.service.impl;

import io.github.linxiaobaixcg.common.util.RedisUtils;
import io.github.linxiaobaixcg.modules.app.controller.vo.UserRegisterVo;
import io.github.linxiaobaixcg.modules.app.entity.VwUser;
import io.github.linxiaobaixcg.modules.app.repository.VwUserRepository;
import io.github.linxiaobaixcg.modules.app.service.VwUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * @author linchuangqiong
 * @date 2019/9/16
 * @Description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class VwUserServiceImplTest {

    @Autowired
    private VwUserRepository vwUserRepository;

    @Autowired
    private VwUserService vwUserService;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void insert() {
        VwUser vwUser = new VwUser();
        vwUser.setLastPasswordResetTime(new Timestamp(System.currentTimeMillis()));
        int a = vwUserRepository.insert(vwUser);
        log.info(a + "");
        assertNotEquals(0, a);
    }

    @Test
    public void register() {
        UserRegisterVo userRegisterVo = new UserRegisterVo();
        userRegisterVo.setUuid("3db2ea6366954b908050ceadf39061ac");
        userRegisterVo.setCode("68YA");
        userRegisterVo.setPhone("18300000000");
        userRegisterVo.setUsername("test");
        userRegisterVo.setPassword("a123456");
        userRegisterVo.setCheckPassword("a123456");
        vwUserService.register(userRegisterVo);
    }
}
