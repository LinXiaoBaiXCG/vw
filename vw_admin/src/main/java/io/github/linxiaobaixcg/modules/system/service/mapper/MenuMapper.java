package io.github.linxiaobaixcg.modules.system.service.mapper;

import io.github.linxiaobaixcg.base.BaseMapper;
import io.github.linxiaobaixcg.modules.system.domain.Menu;
import io.github.linxiaobaixcg.modules.system.service.dto.MenuDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2018-12-17
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends BaseMapper<MenuDto, Menu> {

}
