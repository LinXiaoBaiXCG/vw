package io.github.linxiaobaixcg.service.mapper;

import io.github.linxiaobaixcg.domain.Log;
import io.github.linxiaobaixcg.service.dto.LogErrorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-09T16:30:32+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class LogErrorMapperImpl implements LogErrorMapper {

    @Override
    public Log toEntity(LogErrorDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Log log = new Log();

        log.setId( arg0.getId() );
        log.setUsername( arg0.getUsername() );
        log.setDescription( arg0.getDescription() );
        log.setMethod( arg0.getMethod() );
        log.setParams( arg0.getParams() );
        log.setRequestIp( arg0.getRequestIp() );
        log.setAddress( arg0.getAddress() );
        log.setBrowser( arg0.getBrowser() );
        log.setCreateTime( arg0.getCreateTime() );

        return log;
    }

    @Override
    public LogErrorDTO toDto(Log arg0) {
        if ( arg0 == null ) {
            return null;
        }

        LogErrorDTO logErrorDTO = new LogErrorDTO();

        logErrorDTO.setId( arg0.getId() );
        logErrorDTO.setUsername( arg0.getUsername() );
        logErrorDTO.setDescription( arg0.getDescription() );
        logErrorDTO.setMethod( arg0.getMethod() );
        logErrorDTO.setParams( arg0.getParams() );
        logErrorDTO.setBrowser( arg0.getBrowser() );
        logErrorDTO.setRequestIp( arg0.getRequestIp() );
        logErrorDTO.setAddress( arg0.getAddress() );
        logErrorDTO.setCreateTime( arg0.getCreateTime() );

        return logErrorDTO;
    }

    @Override
    public List<Log> toEntity(List<LogErrorDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Log> list = new ArrayList<Log>( arg0.size() );
        for ( LogErrorDTO logErrorDTO : arg0 ) {
            list.add( toEntity( logErrorDTO ) );
        }

        return list;
    }

    @Override
    public List<LogErrorDTO> toDto(List<Log> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<LogErrorDTO> list = new ArrayList<LogErrorDTO>( arg0.size() );
        for ( Log log : arg0 ) {
            list.add( toDto( log ) );
        }

        return list;
    }
}
