package io.github.linxiaobaixcg.modules.mnt.service.mapper;

import io.github.linxiaobaixcg.modules.mnt.domain.Deploy;
import io.github.linxiaobaixcg.modules.mnt.domain.ServerDeploy;
import io.github.linxiaobaixcg.modules.mnt.service.dto.DeployDto;
import io.github.linxiaobaixcg.modules.mnt.service.dto.ServerDeployDto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-08T23:46:11+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class DeployMapperImpl implements DeployMapper {

    @Autowired
    private AppMapper appMapper;
    @Autowired
    private ServerDeployMapper serverDeployMapper;

    @Override
    public Deploy toEntity(DeployDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Deploy deploy = new Deploy();

        if ( arg0.getId() != null ) {
            deploy.setId( Long.parseLong( arg0.getId() ) );
        }
        deploy.setApp( appMapper.toEntity( arg0.getApp() ) );
        deploy.setDeploys( serverDeployDtoSetToServerDeploySet( arg0.getDeploys() ) );
        deploy.setCreateTime( arg0.getCreateTime() );

        return deploy;
    }

    @Override
    public DeployDto toDto(Deploy arg0) {
        if ( arg0 == null ) {
            return null;
        }

        DeployDto deployDto = new DeployDto();

        if ( arg0.getId() != null ) {
            deployDto.setId( String.valueOf( arg0.getId() ) );
        }
        deployDto.setApp( appMapper.toDto( arg0.getApp() ) );
        deployDto.setDeploys( serverDeploySetToServerDeployDtoSet( arg0.getDeploys() ) );
        deployDto.setCreateTime( arg0.getCreateTime() );

        return deployDto;
    }

    @Override
    public List<Deploy> toEntity(List<DeployDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Deploy> list = new ArrayList<Deploy>( arg0.size() );
        for ( DeployDto deployDto : arg0 ) {
            list.add( toEntity( deployDto ) );
        }

        return list;
    }

    @Override
    public List<DeployDto> toDto(List<Deploy> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<DeployDto> list = new ArrayList<DeployDto>( arg0.size() );
        for ( Deploy deploy : arg0 ) {
            list.add( toDto( deploy ) );
        }

        return list;
    }

    protected Set<ServerDeploy> serverDeployDtoSetToServerDeploySet(Set<ServerDeployDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<ServerDeploy> set1 = new HashSet<ServerDeploy>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ServerDeployDto serverDeployDto : set ) {
            set1.add( serverDeployMapper.toEntity( serverDeployDto ) );
        }

        return set1;
    }

    protected Set<ServerDeployDto> serverDeploySetToServerDeployDtoSet(Set<ServerDeploy> set) {
        if ( set == null ) {
            return null;
        }

        Set<ServerDeployDto> set1 = new HashSet<ServerDeployDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ServerDeploy serverDeploy : set ) {
            set1.add( serverDeployMapper.toDto( serverDeploy ) );
        }

        return set1;
    }
}
