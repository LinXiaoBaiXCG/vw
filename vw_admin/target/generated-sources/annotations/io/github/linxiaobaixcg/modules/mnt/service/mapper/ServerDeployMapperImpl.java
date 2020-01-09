package io.github.linxiaobaixcg.modules.mnt.service.mapper;

import io.github.linxiaobaixcg.modules.mnt.domain.ServerDeploy;
import io.github.linxiaobaixcg.modules.mnt.service.dto.ServerDeployDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-09T16:30:42+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class ServerDeployMapperImpl implements ServerDeployMapper {

    @Override
    public ServerDeploy toEntity(ServerDeployDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        ServerDeploy serverDeploy = new ServerDeploy();

        serverDeploy.setId( arg0.getId() );
        serverDeploy.setName( arg0.getName() );
        serverDeploy.setIp( arg0.getIp() );
        serverDeploy.setPort( arg0.getPort() );
        serverDeploy.setAccount( arg0.getAccount() );
        serverDeploy.setPassword( arg0.getPassword() );
        serverDeploy.setCreateTime( arg0.getCreateTime() );

        return serverDeploy;
    }

    @Override
    public ServerDeployDto toDto(ServerDeploy arg0) {
        if ( arg0 == null ) {
            return null;
        }

        ServerDeployDto serverDeployDto = new ServerDeployDto();

        serverDeployDto.setId( arg0.getId() );
        serverDeployDto.setName( arg0.getName() );
        serverDeployDto.setIp( arg0.getIp() );
        serverDeployDto.setPort( arg0.getPort() );
        serverDeployDto.setAccount( arg0.getAccount() );
        serverDeployDto.setPassword( arg0.getPassword() );
        serverDeployDto.setCreateTime( arg0.getCreateTime() );

        return serverDeployDto;
    }

    @Override
    public List<ServerDeploy> toEntity(List<ServerDeployDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<ServerDeploy> list = new ArrayList<ServerDeploy>( arg0.size() );
        for ( ServerDeployDto serverDeployDto : arg0 ) {
            list.add( toEntity( serverDeployDto ) );
        }

        return list;
    }

    @Override
    public List<ServerDeployDto> toDto(List<ServerDeploy> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<ServerDeployDto> list = new ArrayList<ServerDeployDto>( arg0.size() );
        for ( ServerDeploy serverDeploy : arg0 ) {
            list.add( toDto( serverDeploy ) );
        }

        return list;
    }
}
