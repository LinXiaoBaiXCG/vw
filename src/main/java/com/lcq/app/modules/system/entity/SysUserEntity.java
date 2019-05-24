package com.lcq.app.modules.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * @program: app
 * @description: 用户
 * @author: LCQ
 * @create: 2019-05-20 22:53
 **/
@Data
@TableName("sys_user")
public class SysUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.UUID)
    private String id;
    private String user;
    private String password;
    @TableField(value = "create_date",fill = FieldFill.INSERT)
    private Instant createDate;
    @TableField(value = "update_date",fill = FieldFill.UPDATE)
    private Instant updateDate;
}
