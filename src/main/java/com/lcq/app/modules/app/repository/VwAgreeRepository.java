package com.lcq.app.modules.app.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcq.app.modules.app.entity.VwAgree;
import com.lcq.app.modules.app.entity.VwAnswer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: app
 * @description: VwAgreeRepository
 * @author: LCQ
 * @create: 2019-05-20 23:14
 **/
@Mapper
public interface VwAgreeRepository extends BaseMapper<VwAgree> {

}
