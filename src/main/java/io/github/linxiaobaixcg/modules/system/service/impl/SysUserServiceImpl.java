package io.lcq.app.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.lcq.app.modules.system.entity.SysUserDO;
import io.lcq.app.modules.system.repository.SysUserRepository;
import io.lcq.app.modules.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @program: app
 * @description: SysUserServiceImpl
 * @author: LCQ
 * @create: 2019-05-20 23:28
 **/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserRepository, SysUserDO> implements SysUserService {
    private final SysUserRepository sysUserRepository;

    public SysUserServiceImpl(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    @Override
    public SysUserDO findByUserName(String username) {
        QueryWrapper<SysUserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        SysUserDO sysUserEntity = sysUserRepository.selectOne(queryWrapper);
        return sysUserEntity;
    }
}
