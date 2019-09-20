package io.github.linxiaobaixcg.modules.app.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linchuangqiong
 * @date 2019/9/20
 * @Description
 */
@Data
public class VwAnswerDTO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String problemTitle;

    /**
     * 回答内容
     */
    private String content;

    /**
     * 回答人
     */
    private String username;

    /**
     * 回答人头像
     */
    private String avatar;
}
