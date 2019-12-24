package io.github.linxiaobaixcg;

import io.github.linxiaobaixcg.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/**
 * @program: vw
 * @description: Qa启动类
 * @author: LCQ
 * @create: 2019-12-23 20:24
 **/
@SpringBootApplication
@EnableCaching
public class QaApplication {
    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class,args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
