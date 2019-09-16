package io.github.linxiaobaixcg.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.linxiaobaixcg.modules.app.controller.vo.UserRegisterVo;
import io.github.linxiaobaixcg.modules.app.entity.VwUser;

/**
 * @program: app
 * @description: VwUserService
 * @author: LCQ
 * @create: 2019-05-20 23:26
 **/
public interface VwUserService {

    /**
     * 用户注册
     * @param userRegisterVo
     * @return
     */
    void register(UserRegisterVo userRegisterVo);
}
