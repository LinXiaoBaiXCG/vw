package io.github.linxiaobaixcg.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2019-12-30 23:07
 **/
@Data
public class AnswerVo implements Serializable {

    private String id;

    private String userId;

    private String problemId;

    private String problemTitle;

    private String content;

    private Timestamp updateTime;

    private Integer isAgree;

    private Long agreeCount;
}
