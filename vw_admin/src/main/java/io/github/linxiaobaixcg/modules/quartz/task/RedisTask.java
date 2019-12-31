package io.github.linxiaobaixcg.modules.quartz.task;

import io.github.linxiaobaixcg.modules.system.service.RedisService;
import org.springframework.stereotype.Component;

@Component
public class RedisTask {

    private final RedisService redisService;

    public RedisTask(RedisService redisService) {
        this.redisService = redisService;
    }


    public void run(){
        redisService.transAgreeDataFromRedis2DB();
        redisService.transAgreeCountFromRedis2DB();
    }
}
