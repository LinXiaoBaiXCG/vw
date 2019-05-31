package com.lcq.app.modules.app.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcq.app.modules.app.entity.VwUser;
import com.lcq.app.modules.system.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: app
 * @description: VwUserRepository
 * @author: LCQ
 * @create: 2019-05-20 23:14
 **/
@Mapper
public interface VwUserRepository extends BaseMapper<VwUser> {
}
