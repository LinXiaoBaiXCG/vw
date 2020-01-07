package io.github.linxiaobaixcg.entity.vo;

import lombok.Data;
import sun.security.util.Password;

import java.io.Serializable;

/**
 * @program: vw
 * @description: 用户注册
 * @author: LCQ
 * @create: 2020-01-07 22:35
 **/
@Data
public class UserRegisterVO implements Serializable {

    private String username;

    private String password;

    private String checkPassword;

    private String phone;
}
