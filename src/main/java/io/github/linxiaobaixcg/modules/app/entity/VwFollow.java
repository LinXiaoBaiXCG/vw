package io.github.linxiaobaixcg.modules.app.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * @program: app
 * @description: VwFollow
 * @author: LCQ
 * @create: 2019-05-20 22:53
 **/
@Data
@TableName("vw_follow")
public class VwFollow implements Serializable {
    private static final long serialVersionUID = 6138146583379968814L;

    @TableId(type = IdType.UUID)
    private String id;

    /*
     * 关注人id
     */
    private String userId;

    /*
     * 被关注人id
     */
    private String concernedId;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Instant createTime;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private Instant updateTime;

    /*
    * 不属于表字段
    */
    //被关注人名字
    @TableField(exist = false)
    private String concernedName;
}
