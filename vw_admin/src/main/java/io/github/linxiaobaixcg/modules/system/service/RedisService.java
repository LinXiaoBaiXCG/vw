package io.github.linxiaobaixcg.modules.system.service;

import io.github.linxiaobaixcg.modules.system.domain.Agree;
import io.github.linxiaobaixcg.modules.system.domain.Answer;

import java.util.List;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2019-12-30 23:31
 **/
public interface RedisService {

    /**
     * 将Redis里的点赞数据存入数据库中
     */
    void transAgreeDataFromRedis2DB();

    /**
     * 将Redis中的点赞数量数据存入数据库
     */
    void transAgreeCountFromRedis2DB();

    /**
     * 获取Redis中存储的所有点赞数据
     * @return
     */
    List<Agree> getLikedDataFromRedis();

    /**
     * 获取Redis中存储的所有点赞数量
     * @return
     */
    List<Answer> getLikedCountFromRedis();

}
