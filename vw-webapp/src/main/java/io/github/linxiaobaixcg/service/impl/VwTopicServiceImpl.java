package io.github.linxiaobaixcg.service.impl;

import io.github.linxiaobaixcg.entity.VwTopic;
import io.github.linxiaobaixcg.repository.VwTopicRepository;
import io.github.linxiaobaixcg.service.VwTopicService;
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
