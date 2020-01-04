package io.github.linxiaobaixcg.service;

import io.github.linxiaobaixcg.mapper.ProblemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Target;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProblemServiceTest {

    @Autowired
    ProblemMapper problemMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void insert() {
        problemMapper.selectById(1);
    }

    @Test
    public void test(){
        redisTemplate.getKeySerializer();
    }
}