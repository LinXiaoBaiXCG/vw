package io.github.linxiaobaixcg.modules.app.service.impl;

import io.github.linxiaobaixcg.modules.app.entity.VwUser;
import io.github.linxiaobaixcg.modules.app.repository.VwUserRepository;
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

    @Test
    public void insert() {
        VwUser vwUser = new VwUser();
        vwUser.setLastPasswordResetTime(new Timestamp(System.currentTimeMillis()));
        int a = vwUserRepository.insert(vwUser);
        log.info(a + "");
        assertNotEquals(0, a);
    }

    @Test
    public void update() {
        VwUser vwUser = new VwUser();
        vwUser.setId(1L);
        vwUser.setStatus(1);
        vwUser.setLastPasswordResetTime(new Timestamp(System.currentTimeMillis()));
        int a = vwUserRepository.updateById(vwUser);
        log.info(a + "");
        assertNotEquals(0, a);
    }
}
