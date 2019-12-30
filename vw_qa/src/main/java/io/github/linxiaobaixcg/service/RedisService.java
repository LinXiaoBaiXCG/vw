package io.github.linxiaobaixcg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @program: vw
 * @description: redis业务类
 * @author: LCQ
 * @create: 2019-12-30 22:05
 **/
@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *
     * @param userId
     * @param answerId
     * @param status
     */
    public void saveAgree2Redis(String userId, String answerId, Integer status){
        redisTemplate.opsForValue().get("answer_agree_count"+"::"+answerId);
        // 取消点赞，问答点赞数减1,否则加1
        if (status != null && status == 0){
            redisTemplate.opsForValue().decrement("answer_agree_count"+"::"+answerId,1);
        }else if (status != null && status == 1){
            redisTemplate.opsForValue().increment("answer_agree_count"+"::"+answerId,1);
        }
        // 保存用户点赞记录
        redisTemplate.opsForHash().put("user_agree_answer",userId+"::"+answerId,status);
    }

    /**
     * 获取用户是否点赞问答记录
     * @param userId
     * @param answerId
     * @return
     */
    public Integer getUserAgree(String userId,String answerId){
        return  (Integer)redisTemplate.opsForHash().get("user_agree_answer",userId+"::"+answerId);
    }

    /**
     * 获取问答点赞数
     * @param answerId
     * @return
     */
    public Long getAnswerAgreeCount(String answerId){
        return (Long)redisTemplate.opsForValue().get("answer_agree_count"+"::"+answerId);
    }
}
