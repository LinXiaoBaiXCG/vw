package io.github.linxiaobaixcg.modules.system.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;


@Data
@Entity
@Table(name="vw_answer")
public class Answer implements Serializable {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "problem_id")
    private String problemId;

    @Column(name = "problem_title")
    private String problemTitle;

    @Column(name = "content")
    private String content;

    /**
     * 是否删除 0否1是
     */
    @Column(name = "is_deleted")
    private Integer isDeleted;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "update_time")
    private Timestamp updateTime;

    /**
     * 是否推荐 0否 1是
     */
    @Column(name = "is_recommend")
    private Integer isRecommend;

    /**
     * 回答点赞数
     */
    @Column(name = "agree_count")
    private Long agreeCount;
}