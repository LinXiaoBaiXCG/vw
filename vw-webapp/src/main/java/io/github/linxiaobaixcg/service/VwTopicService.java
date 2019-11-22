package io.github.linxiaobaixcg.service;

import io.github.linxiaobaixcg.entity.VwTopic;

/**
 * @program: app
 * @description: VwProblemService
 * @author: LCQ
 * @create: 2019-05-20 23:26
 **/
public interface VwTopicService {

    /**
     * 添加话题
     * @param vwTopic
     * @return
     */
    int insert(VwTopic vwTopic);
}