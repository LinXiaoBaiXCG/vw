package io.github.linxiaobaixcg.modules.system.service.mapper;

import io.github.linxiaobaixcg.modules.system.domain.Dept;
import io.github.linxiaobaixcg.modules.system.domain.Menu;
import io.github.linxiaobaixcg.modules.system.domain.Role;
import io.github.linxiaobaixcg.modules.system.service.dto.DeptDto;
import io.github.linxiaobaixcg.modules.system.service.dto.MenuDto;
import io.github.linxiaobaixcg.modules.system.service.dto.RoleDto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-09T16:30:42+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Role toEntity(RoleDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( arg0.getId() );
        role.setName( arg0.getName() );
        role.setDataScope( arg0.getDataScope() );
        role.setLevel( arg0.getLevel() );
        role.setRemark( arg0.getRemark() );
        role.setPermission( arg0.getPermission() );
        role.setMenus( menuDtoSetToMenuSet( arg0.getMenus() ) );
        role.setDepts( deptDtoSetToDeptSet( arg0.getDepts() ) );
        role.setCreateTime( arg0.getCreateTime() );

        return role;
    }

    @Override
    public RoleDto toDto(Role arg0) {
        if ( arg0 == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( arg0.getId() );
        roleDto.setName( arg0.getName() );
        roleDto.setDataScope( arg0.getDataScope() );
        roleDto.setLevel( arg0.getLevel() );
        roleDto.setRemark( arg0.getRemark() );
        roleDto.setPermission( arg0.getPermission() );
        roleDto.setMenus( menuSetToMenuDtoSet( arg0.getMenus() ) );
        roleDto.setDepts( deptSetToDeptDtoSet( arg0.getDepts() ) );
        roleDto.setCreateTime( arg0.getCreateTime() );

        return roleDto;
    }

    @Override
    public List<Role> toEntity(List<RoleDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( arg0.size() );
        for ( RoleDto roleDto : arg0 ) {
            list.add( toEntity( roleDto ) );
        }

        return list;
    }

    @Override
    public List<RoleDto> toDto(List<Role> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<RoleDto> list = new ArrayList<RoleDto>( arg0.size() );
        for ( Role role : arg0 ) {
            list.add( toDto( role ) );
        }

        return list;
    }

    protected Set<Menu> menuDtoSetToMenuSet(Set<MenuDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Menu> set1 = new HashSet<Menu>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( MenuDto menuDto : set ) {
            set1.add( menuMapper.toEntity( menuDto ) );
        }

        return set1;
    }

    protected Set<Dept> deptDtoSetToDeptSet(Set<DeptDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Dept> set1 = new HashSet<Dept>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DeptDto deptDto : set ) {
            set1.add( deptMapper.toEntity( deptDto ) );
        }

        return set1;
    }

    protected Set<MenuDto> menuSetToMenuDtoSet(Set<Menu> set) {
        if ( set == null ) {
            return null;
        }

        Set<MenuDto> set1 = new HashSet<MenuDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Menu menu : set ) {
            set1.add( menuMapper.toDto( menu ) );
        }

        return set1;
    }

    protected Set<DeptDto> deptSetToDeptDtoSet(Set<Dept> set) {
        if ( set == null ) {
            return null;
        }

        Set<DeptDto> set1 = new HashSet<DeptDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Dept dept : set ) {
            set1.add( deptMapper.toDto( dept ) );
        }

        return set1;
    }
}
