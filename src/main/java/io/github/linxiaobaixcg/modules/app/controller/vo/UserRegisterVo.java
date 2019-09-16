package io.github.linxiaobaixcg.modules.app.controller.vo;

import lombok.Data;

/**
 * @author linchuangqiong
 * @date 2019/9/16
 * @Description
 */
@Data
public class UserRegisterVo {

    private String uuid;

    private String username;

    private String phone;

    private String password;

    private String checkPassword;

    private String code;
}
