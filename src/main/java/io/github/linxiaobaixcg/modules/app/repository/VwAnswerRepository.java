package io.github.linxiaobaixcg.modules.app.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.modules.app.entity.VwAnswer;
import io.github.linxiaobaixcg.modules.app.service.dto.VwAnswerDTO;
import io.github.linxiaobaixcg.modules.app.service.dto.VwAnswerQueryCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: app
 * @description: VwAnswerRepository
 * @author: LCQ
 * @create: 2019-05-20 23:14
 **/
public interface VwAnswerRepository extends BaseMapper<VwAnswer> {

    /**
     * 获取回答分页
     * @param page
     * @param queryCriteria
     * @return
     */
    IPage<VwAnswerDTO> getPage(Page page, @Param("criteria") VwAnswerQueryCriteria queryCriteria);

    /**
     * 获取回答详细
     * @param id
     * @return
     */
    VwAnswerDTO findOne(@Param("id") Long id);

    /**
     *  查询我的回答列表
     * @param page
     * @param userId
     * @return
     */
    IPage<VwAnswerDTO> findMyAnswer(Page page, @Param("userId") Long userId);

    IPage<VwAnswerDTO> findRecommendList(Page page);
}
