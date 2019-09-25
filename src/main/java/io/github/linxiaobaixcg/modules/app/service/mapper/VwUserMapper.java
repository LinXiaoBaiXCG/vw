package io.github.linxiaobaixcg.modules.app.service.mapper;

import io.github.linxiaobaixcg.common.mapper.EntityMapper;
import io.github.linxiaobaixcg.modules.app.entity.VwUser;
import io.github.linxiaobaixcg.modules.app.service.dto.VwUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VwUserMapper extends EntityMapper<VwUserDTO, VwUser> {

}