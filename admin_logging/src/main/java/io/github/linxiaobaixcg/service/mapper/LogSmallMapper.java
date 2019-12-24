package io.github.linxiaobaixcg.service.mapper;

import io.github.linxiaobaixcg.domain.Log;
import io.github.linxiaobaixcg.service.dto.LogSmallDTO;
import io.github.linxiaobaixcg.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2019-5-22
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogSmallMapper extends BaseMapper<LogSmallDTO, Log> {

}