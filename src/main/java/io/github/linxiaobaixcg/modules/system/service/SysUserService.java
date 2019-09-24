package io.github.linxiaobaixcg.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.linxiaobaixcg.modules.system.entity.SysUserDO;

/**
 * @program: app
 * @description: SysUserService
 * @author: LCQ
 * @create: 2019-05-20 23:26
 **/
public interface SysUserService extends IService<SysUserDO> {

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    SysUserDO findByUserName(String username);
}