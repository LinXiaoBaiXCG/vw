package io.github.linxiaobaixcg.modules.mnt.service.mapper;

import io.github.linxiaobaixcg.modules.mnt.domain.App;
import io.github.linxiaobaixcg.modules.mnt.service.dto.AppDto;
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
public class AppMapperImpl implements AppMapper {

    @Override
    public App toEntity(AppDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        App app = new App();

        app.setId( arg0.getId() );
        app.setName( arg0.getName() );
        if ( arg0.getPort() != null ) {
            app.setPort( arg0.getPort() );
        }
        app.setUploadPath( arg0.getUploadPath() );
        app.setDeployPath( arg0.getDeployPath() );
        app.setBackupPath( arg0.getBackupPath() );
        app.setStartScript( arg0.getStartScript() );
        app.setDeployScript( arg0.getDeployScript() );
        app.setCreateTime( arg0.getCreateTime() );

        return app;
    }

    @Override
    public AppDto toDto(App arg0) {
        if ( arg0 == null ) {
            return null;
        }

        AppDto appDto = new AppDto();

        appDto.setId( arg0.getId() );
        appDto.setName( arg0.getName() );
        appDto.setPort( arg0.getPort() );
        appDto.setUploadPath( arg0.getUploadPath() );
        appDto.setDeployPath( arg0.getDeployPath() );
        appDto.setBackupPath( arg0.getBackupPath() );
        appDto.setStartScript( arg0.getStartScript() );
        appDto.setDeployScript( arg0.getDeployScript() );
        appDto.setCreateTime( arg0.getCreateTime() );

        return appDto;
    }

    @Override
    public List<App> toEntity(List<AppDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<App> list = new ArrayList<App>( arg0.size() );
        for ( AppDto appDto : arg0 ) {
            list.add( toEntity( appDto ) );
        }

        return list;
    }

    @Override
    public List<AppDto> toDto(List<App> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<AppDto> list = new ArrayList<AppDto>( arg0.size() );
        for ( App app : arg0 ) {
            list.add( toDto( app ) );
        }

        return list;
    }
}
