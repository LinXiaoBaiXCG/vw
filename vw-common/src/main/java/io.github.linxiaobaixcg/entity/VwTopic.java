package io.github.linxiaobaixcg.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @program: app
 * @description: 用户
 * @author: LCQ
 * @create: 2019-05-20 22:53
 **/
@Data
@TableName("vw_topic")
public class VwTopic implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "uuid",fill = FieldFill.INSERT)
    private String uuid;

    @NotNull(message = "创建人ID不能为空")
    private Long userId;

    @NotBlank(message = "话题名不能为空")
    private String name;

    @NotBlank(message = "描述不能为空")
    private String introduction;

    /**
     * 状态：1、审核中2、审核成功3、审核失败
     */
    private Integer status;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;
}
