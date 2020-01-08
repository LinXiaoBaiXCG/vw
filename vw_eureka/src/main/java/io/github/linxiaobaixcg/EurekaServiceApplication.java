package io.github.linxiaobaixcg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: vw
 * @description: Eureka服务端启动类
 * @author: LCQ
 * @create: 2020-01-08 21:07
 **/
@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class,args);
    }
}
