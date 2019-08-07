package com.lcq.app.modules.app.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcq.app.modules.app.entity.VwAnswer;
import com.lcq.app.modules.app.entity.VwProblem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: app
 * @description: VwAnswerRepository
 * @author: LCQ
 * @create: 2019-05-20 23:14
 **/
@Mapper
public interface VwAnswerRepository extends BaseMapper<VwAnswer> {

}
