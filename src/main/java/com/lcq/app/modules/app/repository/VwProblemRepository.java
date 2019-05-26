package com.lcq.app.modules.app.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcq.app.modules.app.entity.VwProblem;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: app
 * @description: VwProblemRepository
 * @author: LCQ
 * @create: 2019-05-20 23:14
 **/
@Mapper
public interface VwProblemRepository extends BaseMapper<VwProblem> {
}
