package io.github.linxiaobaixcg.modules.app.controller.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author linchuangqiong
 * @date 2019/9/19
 * @Description
 */
@Data
public class LoginVo {

    @NotBlank(message = "手机号不能为空")
    private String phone;
    @NotBlank(message = "密码不能为空")
    private String password;
}
