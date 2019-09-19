package io.github.linxiaobaixcg.modules.app.service.impl;

import io.github.linxiaobaixcg.modules.app.entity.VwTopic;
import io.github.linxiaobaixcg.modules.app.repository.VwTopicRepository;
import io.github.linxiaobaixcg.modules.app.service.VwTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: app
 * @description: VwProblemServiceImpl
 * @author: LCQ
 * @create: 2019-05-20 23:28
 **/
@Service
public class VwTopicServiceImpl implements VwTopicService {

    @Autowired
    private VwTopicRepository vwTopicRepository;

    @Override
    public int insert(VwTopic vwTopic) {
        return vwTopicRepository.insert(vwTopic);
    }
}
