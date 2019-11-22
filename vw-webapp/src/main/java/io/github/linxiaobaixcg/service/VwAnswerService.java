package io.github.linxiaobaixcg.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.entity.VwAnswer;
import io.github.linxiaobaixcg.service.dto.VwAnswerDTO;
import io.github.linxiaobaixcg.service.dto.VwAnswerQueryCriteria;
import io.github.linxiaobaixcg.service.dto.VwUserAgreeDTO;

/**
 * @program: app
 * @description: VwAnswerService
 * @author: LCQ
 * @create: 2019-05-20 23:26
 **/
public interface VwAnswerService {

    /**
     * 首页列表
     *
     * @param page
     * @param queryCriteria
     * @return
     */
    IPage<VwAnswerDTO> getPage(Page page, VwAnswerQueryCriteria queryCriteria);

    /**
     * 添加回答
     *
     * @param vwAnswer
     * @return
     */
    int insert(VwAnswer vwAnswer);

    /**
     * 获取回答详情
     *
     * @param id
     * @param userUuid
     * @return
     */
    VwAnswerDTO findOne(Long id, String userUuid);

    /**
     * 赞同回答
     * @param uuid 回答uuid
     * @param userIsAgree 用户是否点赞
     * @param userUuid 用户uuid
     * @return VwUserAgreeDTO
     */
    VwUserAgreeDTO agree(String uuid, Boolean userIsAgree, String userUuid);

    /**
     * 我的回答列表
     *
     * @param page
     * @param userId
     * @return
     */
    IPage<VwAnswerDTO> getMyAnswer(Page page, Long userId);

    /**
     * 获取推荐列表
     * @param page
     * @return
     */
    IPage<VwAnswerDTO> getRecommendList(Page page);
}