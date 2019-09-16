package io.github.linxiaobaixcg.modules.system.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.linxiaobaixcg.modules.system.entity.SysUserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: app
 * @description: SysUserRepository
 * @author: LCQ
 * @create: 2019-05-20 23:14
 **/
@Mapper
public interface SysUserRepository extends BaseMapper<SysUserDO> {
}
