package io.github.linxiaobaixcg.modules.system.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @program: vw
 * @description: 用户点赞实体类
 * @author: LCQ
 * @create: 2019-12-30 21:48
 **/
@Data
@Entity
@Table(name="vw_agree")
public class Agree implements Serializable {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "answer_id")
    private String answerId;

    /**
     * 是否删除 0取消点赞1是点赞
     */
    @Column(name = "status")
    private Integer status;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "update_time")
    private Timestamp updateTime;
}
