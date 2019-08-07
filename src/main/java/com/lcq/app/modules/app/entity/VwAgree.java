package com.lcq.app.modules.app.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * @program: app
 * @description: VwAgree
 * @author: LCQ
 * @create: 2019-05-20 22:53
 **/
@Data
@TableName("vw_agree")
public class VwAgree implements Serializable {
    private static final long serialVersionUID = -1136044041830353510L;

    @TableId(type = IdType.UUID)
    private String id;

    /*
     * 点赞者id
     */
    private String userId;

    /*
     * 回答者id
     */
    private String answerMan;

    /*
     * 回答id
     */
    private String answerId;

    private String problemId;

    private String problemTitle;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Instant createTime;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private Instant updateTime;
}
