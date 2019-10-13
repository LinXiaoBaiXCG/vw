package io.github.linxiaobaixcg.modules.app.service;

import io.github.linxiaobaixcg.modules.app.entity.VwUser;
import io.github.linxiaobaixcg.modules.app.entity.vo.UserRegisterVo;
import io.github.linxiaobaixcg.modules.app.service.dto.VwUserDTO;

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

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    VwUserDTO findUserInfo(Long id);

    /**
     * 修改用户信息
     * @param vwUser
     */
    void updateUserInfo(VwUser vwUser);
}
