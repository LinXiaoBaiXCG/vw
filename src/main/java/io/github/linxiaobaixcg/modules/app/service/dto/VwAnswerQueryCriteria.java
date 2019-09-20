package io.github.linxiaobaixcg.modules.app.service.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author linchuangqiong
 * @date 2019/9/20
 * @Description
 */
@Data
public class VwAnswerQueryCriteria {

    /**
     * 类型
     */
    @NotNull(message = "类型不能为空！")
    private Integer type;
}
