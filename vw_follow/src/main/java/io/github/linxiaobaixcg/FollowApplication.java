package io.github.linxiaobaixcg;

import io.github.linxiaobaixcg.utils.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @program: vw
 * @description: 关注系统启动类
 * @author: LCQ
 * @create: 2020-01-09 15:34
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("io.github.linxiaobaixcg.mapper")
public class FollowApplication {

    public static void main(String[] args) {
        SpringApplication.run(FollowApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
