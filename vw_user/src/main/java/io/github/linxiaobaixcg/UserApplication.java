package io.github.linxiaobaixcg;

import io.github.linxiaobaixcg.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @program: vw
 * @description: 用户模块启动类
 * @author: LCQ
 * @create: 2020-01-03 22:13
 **/
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
