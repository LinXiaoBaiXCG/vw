package io.lcq.app.modules.app.controller.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Instant;

/**
 * @program: app
 * @description: VwAnswerSavaVO
 * @author: LCQ
 * @create: 2019-05-20 22:53
 **/
@Data
public class VwAnswerSavaVO {

    @NotBlank(message = "问题ID不能为空")
    private String problemId;

    @NotBlank(message = "问题标题不能为空")
    private String problemTitle;

    @NotBlank(message = "用户ID不能为空")
    private String userId;

    @NotBlank(message = "回答内容不能为空")
    private String content;

}
