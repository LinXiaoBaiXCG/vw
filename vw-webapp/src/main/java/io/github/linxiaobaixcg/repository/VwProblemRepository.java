package io.github.linxiaobaixcg.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.entity.VwProblem;
import org.apache.ibatis.annotations.Param;

/**
 * @program: app
 * @description: VwProblemRepository
 * @author: LCQ
 * @create: 2019-05-20 23:14
 **/
public interface VwProblemRepository extends BaseMapper<VwProblem> {

    /*
     *根据标题查询问题
     */
    IPage<VwProblem> getListByTitle(Page page, @Param("title") String title);
}
