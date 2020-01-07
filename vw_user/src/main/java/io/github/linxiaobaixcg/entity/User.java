package io.github.linxiaobaixcg.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2020-01-06 22:28
 **/
@Data
@TableName("vw_user")
public class User implements Serializable {

    private String id;
    private String username;
    private String password;
    private Timestamp lastPasswordResetTime;
    private String phone;
    private String avatar;
    private String introduction;
    private Integer status;
    private Integer followCount;
    private Integer fansCount;
    private Integer problemCount;
    private Integer answerCount;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Timestamp createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;
}
