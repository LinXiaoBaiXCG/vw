package io.github.linxiaobaixcg.modules.app.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linchuangqiong
 * @date 2019/9/20
 * @Description
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VwAnswerDTO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 回答uuid
     */
    private String uuid;

    /**
     * 问题id
     */
    private Long problemId;

    /**
     * 标题
     */
    private String problemTitle;

    /**
     * 问题描述
     */
    private String problemDetails;

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

    /**
     * 回答数
     */
    private Integer problemCount;

    /**
     * 用户简介
     */
    private String introduction;

    /**
     * 赞同数
     */
    private Long agreeCount;

    /**
     * 用户是否点赞 0:未点赞  1:已点赞
     */
    private Boolean userIsAgree;
}
