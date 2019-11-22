package io.github.linxiaobaixcg.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @program: app
 * @description: VwProblem
 * @author: LCQ
 * @create: 2019-05-20 22:53
 **/
@Data
@TableName("vw_problem")
public class VwProblem implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "uuid",fill = FieldFill.INSERT)
    private String uuid;

    private Long userId;

    @NotBlank(message = "标题不能为空")
    private String title;

    @NotBlank(message = "描述不能为空")
    private String details;

    /**
     * 话题ID
     */
//    @NotNull(message = "话题ID不能为空")
    private Long topicId;

    /**
     * 话题名
     */
//    @NotBlank(message = "话题名不能为空")
    private String topicName;

    /**
     * 是否删除 0否1是
     */
    private Integer isDeleted;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;
}
