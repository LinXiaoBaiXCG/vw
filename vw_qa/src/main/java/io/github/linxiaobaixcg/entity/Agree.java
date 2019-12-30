package io.github.linxiaobaixcg.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @program: vw
 * @description: 用户点赞实体类
 * @author: LCQ
 * @create: 2019-12-30 21:48
 **/
@Data
@TableName("vw_agree")
public class Agree implements Serializable {

    private String id;

    private String userId;

    private String answerId;

    /**
     * 是否删除 0取消点赞1是点赞
     */
    private Integer status;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;
}
