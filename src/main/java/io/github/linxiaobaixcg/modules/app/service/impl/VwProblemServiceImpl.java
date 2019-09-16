package io.lcq.app.modules.app.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.lcq.app.modules.app.entity.VwProblem;
import io.lcq.app.modules.app.repository.VwProblemRepository;
import io.lcq.app.modules.app.service.VwProblemService;
import org.springframework.stereotype.Service;

/**
 * @program: app
 * @description: VwProblemServiceImpl
 * @author: LCQ
 * @create: 2019-05-20 23:28
 **/
@Service
public class VwProblemServiceImpl extends ServiceImpl<VwProblemRepository, VwProblem> implements VwProblemService {
    private final VwProblemRepository vwProblemRepository;

    public VwProblemServiceImpl(VwProblemRepository vwProblemRepository) {
        this.vwProblemRepository = vwProblemRepository;
    }

    @Override
    public IPage<VwProblem> getListByTitle(Page page, String title) {
        return vwProblemRepository.getListByTitle(page,title);
    }
}
