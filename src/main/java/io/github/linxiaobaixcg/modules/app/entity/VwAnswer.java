package io.lcq.app.modules.app.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
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
    private static final long serialVersionUID = -77304080771515365L;

    @TableId(type = IdType.UUID)
    private String id;

    private String problemId;

    private String problemTitle;

    private String userId;

    private String content;

    private Integer isRecommend;

    private Integer isDelete;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Instant createTime;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private Instant updateTime;
}
