package io.github.linxiaobaixcg.modules.system.service.dto;

import lombok.Data;
import io.github.linxiaobaixcg.annotation.Query;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Zheng Jie
 * 公共查询类
 */
@Data
public class RoleQueryCriteria {

    @Query(blurry = "name,remark")
    private String blurry;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
