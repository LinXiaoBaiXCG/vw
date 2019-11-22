package io.github.linxiaobaixcg.service.dto;

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
public class VwUserDTO implements Serializable {

    private String username;

    private String avatar;

    /**
     * 回答数
     */
    private Integer answerCount;

    /**
     * 提问数
     */
    private Integer problemCount;

    /**
     * 关注问题数
     */
    private Integer followProblemCount;

    /**
     * 关注用户数
     */
    private Integer followUserCount;
}
