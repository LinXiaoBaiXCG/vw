package io.github.linxiaobaixcg.modules.system.service.mapper;

import io.github.linxiaobaixcg.modules.system.domain.Menu;
import io.github.linxiaobaixcg.modules.system.service.dto.MenuDto;
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
public class MenuMapperImpl implements MenuMapper {

    @Override
    public Menu toEntity(MenuDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Menu menu = new Menu();

        menu.setId( arg0.getId() );
        menu.setName( arg0.getName() );
        menu.setSort( arg0.getSort() );
        menu.setPath( arg0.getPath() );
        menu.setComponent( arg0.getComponent() );
        menu.setType( arg0.getType() );
        menu.setPermission( arg0.getPermission() );
        menu.setComponentName( arg0.getComponentName() );
        menu.setIcon( arg0.getIcon() );
        menu.setCache( arg0.getCache() );
        menu.setHidden( arg0.getHidden() );
        menu.setPid( arg0.getPid() );
        menu.setIFrame( arg0.getIFrame() );
        menu.setCreateTime( arg0.getCreateTime() );

        return menu;
    }

    @Override
    public MenuDto toDto(Menu arg0) {
        if ( arg0 == null ) {
            return null;
        }

        MenuDto menuDto = new MenuDto();

        menuDto.setId( arg0.getId() );
        menuDto.setType( arg0.getType() );
        menuDto.setPermission( arg0.getPermission() );
        menuDto.setName( arg0.getName() );
        menuDto.setSort( arg0.getSort() );
        menuDto.setPath( arg0.getPath() );
        menuDto.setComponent( arg0.getComponent() );
        menuDto.setPid( arg0.getPid() );
        menuDto.setIFrame( arg0.getIFrame() );
        menuDto.setCache( arg0.getCache() );
        menuDto.setHidden( arg0.getHidden() );
        menuDto.setComponentName( arg0.getComponentName() );
        menuDto.setIcon( arg0.getIcon() );
        menuDto.setCreateTime( arg0.getCreateTime() );

        return menuDto;
    }

    @Override
    public List<Menu> toEntity(List<MenuDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Menu> list = new ArrayList<Menu>( arg0.size() );
        for ( MenuDto menuDto : arg0 ) {
            list.add( toEntity( menuDto ) );
        }

        return list;
    }

    @Override
    public List<MenuDto> toDto(List<Menu> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<MenuDto> list = new ArrayList<MenuDto>( arg0.size() );
        for ( Menu menu : arg0 ) {
            list.add( toDto( menu ) );
        }

        return list;
    }
}
