package io.github.linxiaobaixcg.entity.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @program: app
 * @description: VwFollowVO
 * @author: LCQ
 * @create: 2019-05-20 22:53
 **/
@Data
public class VwFollowVO implements Serializable {
    private static final long serialVersionUID = 8607525937285184193L;

    /*
     * 关注人id
     */
    @NotBlank(message = "关注人ID不能为空")
    private String userId;

    /*
     * 被关注人id
     */
    @NotBlank(message = "被关注人ID不能为空")
    private String concernedId;


}
