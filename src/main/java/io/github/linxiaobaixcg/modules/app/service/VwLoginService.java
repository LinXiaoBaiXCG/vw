package io.github.linxiaobaixcg.modules.app.service;

import io.github.linxiaobaixcg.modules.app.entity.vo.LoginVo;

/**
 * @author linchuangqiong
 * @date 2019/9/16
 * @Description
 */
public interface VwLoginService {

    /**
     * 登录
     * @param loginVo
     * @return
     */
    String login(LoginVo loginVo);
}
