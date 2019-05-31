package com.lcq.app.modules.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcq.app.modules.app.entity.VwUser;
import com.lcq.app.modules.app.repository.VwUserRepository;
import com.lcq.app.modules.app.service.VwUserService;
import com.lcq.app.modules.system.entity.SysUserEntity;
import com.lcq.app.modules.system.repository.SysUserRepository;
import com.lcq.app.modules.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @program: app
 * @description: VwUserServiceImpl
 * @author: LCQ
 * @create: 2019-05-20 23:28
 **/
@Service
public class VwUserServiceImpl extends ServiceImpl<VwUserRepository, VwUser> implements VwUserService {
}
