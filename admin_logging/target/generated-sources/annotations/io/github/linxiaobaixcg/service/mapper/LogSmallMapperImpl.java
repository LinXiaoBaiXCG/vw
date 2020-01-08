package io.github.linxiaobaixcg.service.mapper;

import io.github.linxiaobaixcg.domain.Log;
import io.github.linxiaobaixcg.service.dto.LogSmallDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-08T23:46:04+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class LogSmallMapperImpl implements LogSmallMapper {

    @Override
    public Log toEntity(LogSmallDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Log log = new Log();

        log.setDescription( arg0.getDescription() );
        log.setRequestIp( arg0.getRequestIp() );
        log.setAddress( arg0.getAddress() );
        log.setBrowser( arg0.getBrowser() );
        log.setTime( arg0.getTime() );
        log.setCreateTime( arg0.getCreateTime() );

        return log;
    }

    @Override
    public LogSmallDTO toDto(Log arg0) {
        if ( arg0 == null ) {
            return null;
        }

        LogSmallDTO logSmallDTO = new LogSmallDTO();

        logSmallDTO.setDescription( arg0.getDescription() );
        logSmallDTO.setRequestIp( arg0.getRequestIp() );
        logSmallDTO.setTime( arg0.getTime() );
        logSmallDTO.setAddress( arg0.getAddress() );
        logSmallDTO.setBrowser( arg0.getBrowser() );
        logSmallDTO.setCreateTime( arg0.getCreateTime() );

        return logSmallDTO;
    }

    @Override
    public List<Log> toEntity(List<LogSmallDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Log> list = new ArrayList<Log>( arg0.size() );
        for ( LogSmallDTO logSmallDTO : arg0 ) {
            list.add( toEntity( logSmallDTO ) );
        }

        return list;
    }

    @Override
    public List<LogSmallDTO> toDto(List<Log> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<LogSmallDTO> list = new ArrayList<LogSmallDTO>( arg0.size() );
        for ( Log log : arg0 ) {
            list.add( toDto( log ) );
        }

        return list;
    }
}
