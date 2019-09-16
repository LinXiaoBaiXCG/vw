package io.github.linxiaobaixcg.modules.app.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.modules.app.entity.VwAnswer;
import io.github.linxiaobaixcg.modules.app.entity.VwFollow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: app
 * @description: VwFollowRepository
 * @author: LCQ
 * @create: 2019-05-20 23:14
 **/
public interface VwFollowRepository extends BaseMapper<VwFollow> {

    /*
     *获取我的关注列表
     */
    IPage<VwFollow> getPageByUserId(Page page, @Param("userId")String userId);

    IPage<VwAnswer> answerPage(Page page, @Param("userId")String userId, @Param("concernedIds") List<String> concernedId);
}
