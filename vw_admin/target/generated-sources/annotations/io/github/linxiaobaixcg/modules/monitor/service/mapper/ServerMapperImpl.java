package io.github.linxiaobaixcg.modules.monitor.service.mapper;

import io.github.linxiaobaixcg.modules.monitor.domain.Server;
import io.github.linxiaobaixcg.modules.monitor.service.dto.ServerDTO;
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
public class ServerMapperImpl implements ServerMapper {

    @Override
    public Server toEntity(ServerDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Server server = new Server();

        server.setId( arg0.getId() );
        server.setName( arg0.getName() );
        server.setAddress( arg0.getAddress() );
        server.setPort( arg0.getPort() );
        server.setState( arg0.getState() );
        if ( arg0.getCpuRate() != null ) {
            server.setCpuRate( arg0.getCpuRate().doubleValue() );
        }
        server.setCpuCore( arg0.getCpuCore() );
        if ( arg0.getMemTotal() != null ) {
            server.setMemTotal( arg0.getMemTotal().doubleValue() );
        }
        if ( arg0.getMemUsed() != null ) {
            server.setMemUsed( arg0.getMemUsed().doubleValue() );
        }
        if ( arg0.getDiskTotal() != null ) {
            server.setDiskTotal( arg0.getDiskTotal().doubleValue() );
        }
        if ( arg0.getDiskUsed() != null ) {
            server.setDiskUsed( arg0.getDiskUsed().doubleValue() );
        }
        if ( arg0.getSwapTotal() != null ) {
            server.setSwapTotal( arg0.getSwapTotal().doubleValue() );
        }
        if ( arg0.getSwapUsed() != null ) {
            server.setSwapUsed( arg0.getSwapUsed().doubleValue() );
        }
        server.setSort( arg0.getSort() );

        return server;
    }

    @Override
    public ServerDTO toDto(Server arg0) {
        if ( arg0 == null ) {
            return null;
        }

        ServerDTO serverDTO = new ServerDTO();

        serverDTO.setId( arg0.getId() );
        serverDTO.setName( arg0.getName() );
        serverDTO.setAddress( arg0.getAddress() );
        serverDTO.setPort( arg0.getPort() );
        serverDTO.setState( arg0.getState() );
        if ( arg0.getCpuRate() != null ) {
            serverDTO.setCpuRate( arg0.getCpuRate().floatValue() );
        }
        serverDTO.setCpuCore( arg0.getCpuCore() );
        if ( arg0.getMemTotal() != null ) {
            serverDTO.setMemTotal( arg0.getMemTotal().floatValue() );
        }
        if ( arg0.getMemUsed() != null ) {
            serverDTO.setMemUsed( arg0.getMemUsed().floatValue() );
        }
        if ( arg0.getDiskTotal() != null ) {
            serverDTO.setDiskTotal( arg0.getDiskTotal().floatValue() );
        }
        if ( arg0.getDiskUsed() != null ) {
            serverDTO.setDiskUsed( arg0.getDiskUsed().floatValue() );
        }
        if ( arg0.getSwapTotal() != null ) {
            serverDTO.setSwapTotal( arg0.getSwapTotal().floatValue() );
        }
        if ( arg0.getSwapUsed() != null ) {
            serverDTO.setSwapUsed( arg0.getSwapUsed().floatValue() );
        }
        serverDTO.setSort( arg0.getSort() );

        return serverDTO;
    }

    @Override
    public List<Server> toEntity(List<ServerDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Server> list = new ArrayList<Server>( arg0.size() );
        for ( ServerDTO serverDTO : arg0 ) {
            list.add( toEntity( serverDTO ) );
        }

        return list;
    }

    @Override
    public List<ServerDTO> toDto(List<Server> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<ServerDTO> list = new ArrayList<ServerDTO>( arg0.size() );
        for ( Server server : arg0 ) {
            list.add( toDto( server ) );
        }

        return list;
    }
}
