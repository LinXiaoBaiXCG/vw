package io.lcq.app.modules.app.entity;

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
@TableName("vw_user")
public class VwUser implements Serializable {
    private static final long serialVersionUID = -8107952772731662815L;

    @TableId(type = IdType.UUID)
    private String id;

    private String username;

    private String password;

    private String mobile;

    private String email;

    private String wx_openid;

    private String picture;

    private Integer status;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Instant createTime;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private Instant updateTime;
}
