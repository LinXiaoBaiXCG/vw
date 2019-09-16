package io.github.linxiaobaixcg.modules.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.linxiaobaixcg.modules.app.entity.VwUser;
import io.github.linxiaobaixcg.modules.app.service.VwUserService;
import io.github.linxiaobaixcg.modules.app.repository.VwUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: app
 * @description: VwUserServiceImpl
 * @author: LCQ
 * @create: 2019-05-20 23:28
 **/
@Service
public class VwUserServiceImpl implements VwUserService {

    @Autowired
    VwUserRepository vwUserRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(VwUser resources) {
        //验证验证码是否正确

        //验证手机号是否存在

        //验证用户名是否存在

        //验证两次密码是否一致

        //执行注册

    }
}
