package io.lcq.app.modules.app.controller.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Instant;

/**
 * @program: app
 * @description: VwAgreeVO
 * @author: LCQ
 * @create: 2019-05-20 22:53
 **/
@Data
public class VwAgreeVO implements Serializable {
    private static final long serialVersionUID = 3382889115086466218L;

    /*
     * 点赞者id
     */
    @NotBlank(message = "点赞者ID不能为空")
    private String userId;

    /*
     * 回答者id
     */
    @NotBlank(message = "回答者ID不能为空")
    private String answerMan;

    /*
     * 回答id
     */
    @NotBlank(message = "回答ID不能为空")
    private String answerId;

    @NotBlank(message = "问题ID不能为空")
    private String problemId;

    @NotBlank(message = "问题标题不能为空")
    private String problemTitle;
}
