package io.github.linxiaobaixcg.modules.app.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.modules.app.entity.VwProblem;
import io.github.linxiaobaixcg.modules.app.repository.VwProblemRepository;
import io.github.linxiaobaixcg.modules.app.service.VwProblemService;
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
    public IPage<VwProblem> getListByTitle(Page page, String title) {
        return vwProblemRepository.getListByTitle(page,title);
    }

    @Override
    public int addProblem(VwProblem vwProblem) {
        return vwProblemRepository.insert(vwProblem);
    }
}
