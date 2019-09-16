package io.lcq.app.modules.app.controller.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value = "问题VO")
public class VwProblemVO {

    @NotBlank(message = "用户ID不能为空")
    private String userId;

    @NotBlank(message = "问题标题不能为空")
    private String title;

    private String vwDescribe;
}
