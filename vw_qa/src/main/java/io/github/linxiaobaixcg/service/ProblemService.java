package io.github.linxiaobaixcg.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.entity.Problem;
import io.github.linxiaobaixcg.mapper.ProblemMapper;
import io.github.linxiaobaixcg.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
public class ProblemService {

    @Autowired
    private ProblemMapper problemMapper;
    @Autowired
    private IdWorker idWorker;

    /**
     * 添加问题
     * @param problem
     * @return
     */
    @CacheEvict(value ="problem.findByUserId",allEntries = true)
    public int insert(Problem problem){
        problem.setId(idWorker.nextId()+"");
        return problemMapper.insert(problem);
    }

    /**
     * 获取用户创建的问题
     * @param userId
     * @param page
     * @return
     */
    @Cacheable(value = "problem.findByUserId",key = "#userId")
    public IPage<Problem> findByUserId(String userId, Page page){
        QueryWrapper<Problem> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",userId);
        return problemMapper.selectPage(page,queryWrapper);
    }
}
