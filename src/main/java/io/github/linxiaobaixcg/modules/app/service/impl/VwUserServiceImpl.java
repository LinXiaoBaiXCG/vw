package io.lcq.app.modules.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.lcq.app.modules.app.entity.VwUser;
import io.lcq.app.modules.app.repository.VwUserRepository;
import io.lcq.app.modules.app.service.VwUserService;
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
