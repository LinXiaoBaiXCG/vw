package com.lcq.app.modules.app.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * @program: app
 * @description: 问题POJO
 * @author: LCQ
 * @create: 2019-05-20 22:53
 **/
@Data
@TableName("vw_problem")
public class VwProblem implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.UUID)
    private String id;

    private String userId;

    private String title;

    private String vwDescribe;

    private Integer status;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Instant createTime;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private Instant updateTime;
}
