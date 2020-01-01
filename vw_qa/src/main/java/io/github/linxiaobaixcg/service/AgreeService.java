package io.github.linxiaobaixcg.service;

import io.github.linxiaobaixcg.entity.Agree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2019-12-30 21:51
 **/
@Service
@Transactional
public class AgreeService {

    @Autowired
    private RedisService redisService;

    /**
     * 用户点赞问题操作
     * @param agree
     * @return
     */
    public void agreeAnswer(Agree agree){
        redisService.saveAgree2Redis(agree.getUserId(),agree.getAnswerId(),agree.getStatus());
    }
}
