package io.github.linxiaobaixcg;

import io.github.linxiaobaixcg.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2020-01-03 22:11
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JwtTest {

    @Autowired
    JwtUtils jwtUtils;

    @Test
    public void shengcheng(){
        String token = jwtUtils.generateToken("1");
        log.info(token);
    }

    @Test
    public void check(){
        Claims claims = jwtUtils.getClaimByToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTc4MDYxMjg5LCJleHAiOjE1Nzg2NjYwODl9.37Xa2n3NweLvZzLn3OJYRlQ7kY1OlJzC-YjAC7jlpMZ8toeHD28W-e4wR66Q06unJ_oNSm6vgK9oqcNwLHbptg");

        log.info(claims.getSubject()+"------"+"------"+claims.getExpiration());
    }
}
