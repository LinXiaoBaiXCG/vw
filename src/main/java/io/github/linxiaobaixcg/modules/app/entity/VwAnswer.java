package io.github.linxiaobaixcg.modules.app.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * @program: app
 * @description: VwAnswer
 * @author: LCQ
 * @create: 2019-05-20 22:53
 **/
@Data
@TableName("vw_answer")
public class VwAnswer implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "uuid",fill = FieldFill.INSERT)
    private String uuid;

    private Long userId;

    private Long problemId;

    private String problemTitle;

    private String content;

    /**
     * 是否删除 0否1是
     */
    private Integer isDeleted;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;

    /**
     * 是否推荐 0否 1是
     */
    private Integer isRecommend;
}
