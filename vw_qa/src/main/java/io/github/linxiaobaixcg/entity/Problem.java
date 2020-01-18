package io.github.linxiaobaixcg.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @program: vw
 * @description: 问题实体类
 * @author: LCQ
 * @create: 2019-12-23 20:31
 **/
@Data
@TableName("vw_problem")
public class Problem implements Serializable {

    private Long id;

    private Long userId;

    private String title;

    private String details;

    private String topicId;

    private String topicName;

    private Integer isDeleted;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;
}
