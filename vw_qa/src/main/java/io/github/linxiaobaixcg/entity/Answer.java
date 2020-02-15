package io.github.linxiaobaixcg.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@TableName("vw_answer")
public class Answer implements Serializable {

    private Long id;

    private Long userId;

    private Long problemId;

    private String problemTitle;

    private String content;

    /**
     * 是否删除 0否1是
     */
    private Integer isDeleted;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;

    /**
     * 是否推荐 0否 1是
     */
    private Integer isRecommend;

    /**
     * 回答点赞数
     */
    private Integer agreeCount;
}