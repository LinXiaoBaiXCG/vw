package io.github.linxiaobaixcg.service.mapper;

import io.github.linxiaobaixcg.mapper.EntityMapper;
import io.github.linxiaobaixcg.entity.VwUser;
import io.github.linxiaobaixcg.service.dto.VwUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VwUserMapper extends EntityMapper<VwUserDTO, VwUser> {

}