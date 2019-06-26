package com.lcq.app.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lcq.app.modules.system.entity.SysUserDO;

/**
 * @program: app
 * @description: SysUserService
 * @author: LCQ
 * @create: 2019-05-20 23:26
 **/
public interface SysUserService extends IService<SysUserDO> {

    SysUserDO findByUserName(String username);
}
