package io.github.linxiaobaixcg.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.entity.Answer;
import io.github.linxiaobaixcg.mapper.AnswerMapper;
import io.github.linxiaobaixcg.utils.IdWorker;
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
    private RedisTemplate redisTemplate;

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
     * @param id
     * @return
     */
    public Answer findOne(String id){
        //TODO 还需返回回答点赞数和用户是否点赞
        return answerMapper.selectById(id);
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

    public Boolean agreeAnswer(String id, String userId,Integer status){
        //返回是否点赞
        Boolean flag = true;
       if (status!= null && status == 1){
           //status为1时，执行点赞操作
           //点赞数加1
           redisTemplate.opsForValue().increment("answer_agree_count_"+id,1L);
           //标识用户是否点赞
           redisTemplate.opsForValue().set("user_agree_answer_"+userId+id,"1");
           flag = true;
       }else if (status!= null && status == 2){
           //status为2时，执行取消点赞操作
           //点赞数减1
           redisTemplate.opsForValue().decrement("answer_agree_count_"+id,1L);
           //删除用户点赞记录
           redisTemplate.delete("user_agree_answer_"+userId+id);
           flag = false;
       }
       return  flag;
    }
}
