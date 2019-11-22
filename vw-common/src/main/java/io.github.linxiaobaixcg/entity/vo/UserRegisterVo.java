package io.github.linxiaobaixcg.entity.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author linchuangqiong
 * @date 2019/9/16
 * @Description
 */
@Data
public class UserRegisterVo {

    @NotBlank(message = "uuid不能为空!")
    private String uuid;

    @NotBlank(message = "用户名不能为空!")
    private String username;

    @NotBlank(message = "手机号码不能为空!")
    private String phone;

    @NotBlank(message = "密码不能为空!")
    private String password;

    @NotBlank(message = "确认密码不能为空!")
    private String checkPassword;

    @NotBlank(message = "验证码不能为空!")
    private String code;
}
