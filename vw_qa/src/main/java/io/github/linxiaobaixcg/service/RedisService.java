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

    public final static String ANSWER_AGREE_COUNT = "answer_agree_count";
    public final static String USER_AGREE_ANSWER = "user_agree_answer";

    /**
     *
     * @param userId
     * @param answerId
     * @param status
     */
    public void saveAgree2Redis(Long userId, Long answerId, Integer status){
        // 取消点赞，问答点赞数减1,否则加1
        if (status != null && status == 0){
            redisTemplate.opsForHash().increment(ANSWER_AGREE_COUNT,answerId,-1L);
        }else if (status != null && status == 1){
            redisTemplate.opsForHash().increment(ANSWER_AGREE_COUNT,answerId,1L);
        }
        // 保存用户点赞记录
        redisTemplate.opsForHash().put(USER_AGREE_ANSWER,userId+"::"+answerId,status);
    }

    /**
     * 获取用户是否点赞问答记录
     * @param userId
     * @param answerId
     * @return
     */
    public Integer getUserAgree(Long userId,Long answerId){
        return  (Integer)redisTemplate.opsForHash().get(USER_AGREE_ANSWER,userId+"::"+answerId);
    }

    /**
     * 获取问答点赞数
     * @param answerId
     * @return
     */
    public Long getAnswerAgreeCount(Long answerId){
        return Long.parseLong(redisTemplate.opsForHash().get(ANSWER_AGREE_COUNT,answerId).toString());
    }
}
