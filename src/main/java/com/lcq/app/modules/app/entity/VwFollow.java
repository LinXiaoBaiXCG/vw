package com.lcq.app.modules.app.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * @program: app
 * @description: VwFollow
 * @author: LCQ
 * @create: 2019-05-20 22:53
 **/
@Data
@TableName("vc_follow")
public class VwFollow implements Serializable {
    private static final long serialVersionUID = 6138146583379968814L;

    @TableId(type = IdType.UUID)
    private String id;

    /*
     * 关注人id
     */
    private String userId;

    /*
     * 被关注人id
     */
    private String concerned_id;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Instant createTime;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private Instant updateTime;
}
