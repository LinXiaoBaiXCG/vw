package io.github.linxiaobaixcg.modules.system.service.dto;

import lombok.Data;
import io.github.linxiaobaixcg.annotation.Query;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
@Data
public class DictDetailQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String label;

    @Query(propName = "name",joinName = "dict")
    private String dictName;
}