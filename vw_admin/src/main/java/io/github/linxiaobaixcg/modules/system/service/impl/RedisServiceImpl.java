package io.github.linxiaobaixcg.modules.system.service.impl;

import cn.hutool.core.lang.UUID;
import io.github.linxiaobaixcg.modules.system.domain.Agree;
import io.github.linxiaobaixcg.modules.system.domain.Answer;
import io.github.linxiaobaixcg.modules.system.domain.Job;
import io.github.linxiaobaixcg.modules.system.repository.AgreeRepository;
import io.github.linxiaobaixcg.modules.system.repository.AnswerRepository;
import io.github.linxiaobaixcg.modules.system.repository.DeptRepository;
import io.github.linxiaobaixcg.modules.system.repository.JobRepository;
import io.github.linxiaobaixcg.modules.system.service.JobService;
import io.github.linxiaobaixcg.modules.system.service.RedisService;
import io.github.linxiaobaixcg.modules.system.service.dto.JobDto;
import io.github.linxiaobaixcg.modules.system.service.dto.JobQueryCriteria;
import io.github.linxiaobaixcg.modules.system.service.mapper.JobMapper;
import io.github.linxiaobaixcg.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.UUEncoder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

/**
* @author Zheng Jie
* @date 2019-03-29
*/
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private AgreeRepository agreeRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    @Transactional
    public void transAgreeDataFromRedis2DB() {
        List<Agree> list = this.getLikedDataFromRedis();
        for (Agree agree : list) {
            Agree checkAgree = agreeRepository.findByUserIdAndAnswerId(agree.getUserId(), agree.getAnswerId());
            if (checkAgree == null){
                //没有记录，直接存入
                agreeRepository.save(agree);
            }else{
                //有记录，需要更新
                agreeRepository.update(checkAgree.getId(),agree.getStatus());
            }
        }
    }

    @Override
    @Transactional
    public void transAgreeCountFromRedis2DB() {
        List<Answer> list = this.getLikedCountFromRedis();
        for (Answer answer : list) {
            Answer answer1 = answerRepository.findById(answer.getId()).get();
            if (answer1 != null){
                Long agreeCount = answer1.getAgreeCount() + answer.getAgreeCount();
                //更新点赞数量
                answerRepository.updateAgreeCount(answer1.getId(),agreeCount);
            }
        }
    }

    @Override
    public List<Agree> getLikedDataFromRedis() {
        Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan("user_agree_answer", ScanOptions.NONE);
        List<Agree> list = new ArrayList<>();
        while (cursor.hasNext()){
            Map.Entry<Object, Object> entry = cursor.next();
            String key = (String) entry.getKey();
            //分离出 userId，answerId
            String[] split = key.split("::");
            String userId = split[0];
            String answerId = split[1];
            Integer value = (Integer) entry.getValue();

            //组装成 UserLike 对象
            Agree agree = new Agree();
            IdWorker idWorker = new IdWorker(1,1);
            agree.setId(idWorker.nextId()+"");
            agree.setUserId(userId);
            agree.setAnswerId(answerId);
            agree.setStatus(value);
            agree.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
            agree.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
            list.add(agree);
            //存到 list 后从 Redis 中删除
            redisTemplate.opsForHash().delete("user_agree_answer", key);
        }

        return list;
    }

    @Override
    public List<Answer> getLikedCountFromRedis() {
        Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan("answer_agree_count", ScanOptions.NONE);
        List<Answer> list = new ArrayList<>();
        while (cursor.hasNext()){
            Map.Entry<Object, Object> map = cursor.next();
            //将点赞数量存储在Answer
            String key = (String)map.getKey();
            Answer answer = new Answer();
            answer.setId(key);
            answer.setAgreeCount(Long.parseLong(map.getValue().toString()));
            list.add(answer);
            //从Redis中删除这条记录
            redisTemplate.opsForHash().delete("answer_agree_count", key);
        }
        return list;
    }
}