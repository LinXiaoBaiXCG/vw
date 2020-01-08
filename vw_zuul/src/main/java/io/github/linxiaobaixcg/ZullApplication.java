package io.github.linxiaobaixcg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2020-01-08 23:11
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZullApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZullApplication.class,args);
    }
}
