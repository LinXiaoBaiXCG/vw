package io.github.linxiaobaixcg.modules.system.service.mapper;

import io.github.linxiaobaixcg.base.BaseMapper;
import io.github.linxiaobaixcg.modules.system.domain.DictDetail;
import io.github.linxiaobaixcg.modules.system.service.dto.DictDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
@Mapper(componentModel = "spring", uses = {DictSmallMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailMapper extends BaseMapper<DictDetailDto, DictDetail> {

}