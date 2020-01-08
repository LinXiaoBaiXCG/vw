package io.github.linxiaobaixcg.modules.system.service.mapper;

import io.github.linxiaobaixcg.modules.system.domain.Role;
import io.github.linxiaobaixcg.modules.system.service.dto.RoleSmallDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-08T23:46:12+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class RoleSmallMapperImpl implements RoleSmallMapper {

    @Override
    public Role toEntity(RoleSmallDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( arg0.getId() );
        role.setName( arg0.getName() );
        role.setDataScope( arg0.getDataScope() );
        role.setLevel( arg0.getLevel() );

        return role;
    }

    @Override
    public RoleSmallDto toDto(Role arg0) {
        if ( arg0 == null ) {
            return null;
        }

        RoleSmallDto roleSmallDto = new RoleSmallDto();

        roleSmallDto.setId( arg0.getId() );
        roleSmallDto.setName( arg0.getName() );
        roleSmallDto.setLevel( arg0.getLevel() );
        roleSmallDto.setDataScope( arg0.getDataScope() );

        return roleSmallDto;
    }

    @Override
    public List<Role> toEntity(List<RoleSmallDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( arg0.size() );
        for ( RoleSmallDto roleSmallDto : arg0 ) {
            list.add( toEntity( roleSmallDto ) );
        }

        return list;
    }

    @Override
    public List<RoleSmallDto> toDto(List<Role> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<RoleSmallDto> list = new ArrayList<RoleSmallDto>( arg0.size() );
        for ( Role role : arg0 ) {
            list.add( toDto( role ) );
        }

        return list;
    }
}
