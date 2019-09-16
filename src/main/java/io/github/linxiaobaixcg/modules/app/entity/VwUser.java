package io.github.linxiaobaixcg.modules.app.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

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

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "uuid",fill = FieldFill.INSERT)
    private String uuid;

    private String username;

    private String password;

    /**
     * 密码最后更新时间
     */
    private Timestamp lastPasswordResetTime;

    private String phone;

    private String wx_openid;

    private String avatar;

    /**
     * 状态0启用1禁用
     */
    private Integer status;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;
}
