package io.github.linxiaobaixcg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.entity.VwProblem;
import io.github.linxiaobaixcg.repository.VwProblemRepository;
import io.github.linxiaobaixcg.service.VwProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: app
 * @description: VwProblemServiceImpl
 * @author: LCQ
 * @create: 2019-05-20 23:28
 **/
@Service
public class VwProblemServiceImpl implements VwProblemService {

    @Autowired
    private VwProblemRepository vwProblemRepository;

    @Override
    public IPage<VwProblem> getUserProblem(Page page, Long userId) {
        QueryWrapper<VwProblem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("is_deleted", 0);
        return vwProblemRepository.selectPage(page,queryWrapper);
    }

    @Override
    public int addProblem(VwProblem vwProblem) {
        return vwProblemRepository.insert(vwProblem);
    }

    @Override
    public IPage<VwProblem> getByTitle(Page page, String title) {
        QueryWrapper<VwProblem> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", title);
        queryWrapper.eq("is_deleted", 0);
        return vwProblemRepository.selectPage(page,queryWrapper);
    }
}
