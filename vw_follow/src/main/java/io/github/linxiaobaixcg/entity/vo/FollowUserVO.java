package io.github.linxiaobaixcg.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2020-01-09 16:04
 **/
@Data
public class FollowUserVO implements Serializable {

    private String id;

    private String username;

    private String avatar;

    private String introduction;
}
