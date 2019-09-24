package io.github.linxiaobaixcg.modules.app.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linchuangqiong
 * @date 2019/9/24
 * @Description
 */
@Data
public class VwUserAgreeDTO implements Serializable {

    /**
     * 用户是否点赞
     */
    private Boolean userIsAgree;
}
