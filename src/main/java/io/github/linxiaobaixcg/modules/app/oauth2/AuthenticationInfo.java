package io.github.linxiaobaixcg.modules.app.oauth2;

import io.github.linxiaobaixcg.modules.app.entity.VwUser;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * @program: app
 * @description: 用户
 * @author: LCQ
 * @create: 2019-05-20 22:53
 **/
@Getter
@AllArgsConstructor
public class AuthenticationInfo implements Serializable {

    private final String token;

    private final VwUser user;
}
