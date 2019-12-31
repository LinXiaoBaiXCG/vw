package io.github.linxiaobaixcg.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.entity.Agree;
import io.github.linxiaobaixcg.entity.Answer;
import io.github.linxiaobaixcg.entity.VO.AnswerVO;
import io.github.linxiaobaixcg.mapper.AgreeMapper;
import io.github.linxiaobaixcg.mapper.AnswerMapper;
import io.github.linxiaobaixcg.utils.IdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: vw
 * @description: 问题业务类
 * @author: LCQ
 * @create: 2019-12-23 20:42
 **/
@Service
@Transactional
public class AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisService redisService;

    @Autowired
    private AgreeMapper agreeMapper;

    /**
     * 添加回答
     * @param answer
     */
    public void add(Answer answer){
        answer.setId(idWorker.nextId()+"");
        answerMapper.insert(answer);
    }

    /**
     * 获取回答详情
     * @param answerId
     * @param userId
     * @return
     */
    public AnswerVO findOne(String answerId, String userId){
        Answer answer =answerMapper.selectById(answerId);
        AnswerVO answerVO = new AnswerVO();
        BeanUtils.copyProperties(answer,answerVO);
        Long cachingAgreeCount = redisService.getAnswerAgreeCount(answerId);
        System.out.println(cachingAgreeCount);
        answerVO.setAgreeCount(answer.getAgreeCount()+(cachingAgreeCount==null?0L:cachingAgreeCount));
        Integer isAgree = redisService.getUserAgree(userId,answerId);
        if (isAgree != null && isAgree == 1){
            answerVO.setIsAgree(1);
        }else{
            QueryWrapper<Agree> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id",userId);
            Agree agree = agreeMapper.selectOne(queryWrapper);
            if (agree != null && agree.getStatus() == 1){
                answerVO.setIsAgree(1);
            }else {
                answerVO.setIsAgree(0);
            }
        }
        return answerVO;
    }

    /**
     * 获取推荐列表
     * @param page
     * @return
     */
    public IPage<Answer> findRecommendList(Page page){
        QueryWrapper<Answer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_commend",1);
        queryWrapper.eq("is_deleted",0);
        return answerMapper.selectPage(page,queryWrapper);
    }

    /**
     * 获取用户回答列表
     * @param userId
     * @param page
     * @return
     */
    public IPage<Answer> findListByUserId(String userId,Page page){
        QueryWrapper<Answer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("is_deleted",0);
        return answerMapper.selectPage(page,queryWrapper);
    }

}
