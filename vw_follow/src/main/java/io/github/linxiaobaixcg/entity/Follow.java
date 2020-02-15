package io.github.linxiaobaixcg.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @program: vw
 * @description: 关注实体类
 * @author: LCQ
 * @create: 2020-01-09 15:33
 **/
@Data
@TableName(value = "vw_follow")
public class Follow implements Serializable {

    private Long id;

    private Long userId;

    @NotNull(message = "关注对象ID不能为空")
    private Long objectId;

    private Integer type;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;
}
