package io.github.linxiaobaixcg.modules.app.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.modules.app.entity.VwAnswer;
import io.github.linxiaobaixcg.modules.app.repository.VwAnswerRepository;
import io.github.linxiaobaixcg.modules.app.service.VwAnswerService;
import io.github.linxiaobaixcg.modules.app.service.dto.VwAnswerDTO;
import io.github.linxiaobaixcg.modules.app.service.dto.VwAnswerQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: app
 * @description: VwAnswerServiceImpl
 * @author: LCQ
 * @create: 2019-05-20 23:28
 **/
@Service
public class VwAnswerServiceImpl implements VwAnswerService {

    @Autowired
    private VwAnswerRepository vwAnswerRepository;

    @Override
    public IPage<VwAnswerDTO> getPage(Page page, VwAnswerQueryCriteria queryCriteria) {
        return vwAnswerRepository.getPage(page, queryCriteria);
    }

    @Override
    public int insert(VwAnswer vwAnswer) {
        return vwAnswerRepository.insert(vwAnswer);
    }

    @Override
    public VwAnswer findOne(Long id) {
        return vwAnswerRepository.selectById(id);
    }
}
