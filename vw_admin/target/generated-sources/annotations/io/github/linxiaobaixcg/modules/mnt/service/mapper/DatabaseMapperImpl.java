package io.github.linxiaobaixcg.modules.mnt.service.mapper;

import io.github.linxiaobaixcg.modules.mnt.domain.Database;
import io.github.linxiaobaixcg.modules.mnt.service.dto.DatabaseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-08T23:46:11+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class DatabaseMapperImpl implements DatabaseMapper {

    @Override
    public Database toEntity(DatabaseDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Database database = new Database();

        database.setId( arg0.getId() );
        database.setName( arg0.getName() );
        database.setJdbcUrl( arg0.getJdbcUrl() );
        database.setPwd( arg0.getPwd() );
        database.setUserName( arg0.getUserName() );
        database.setCreateTime( arg0.getCreateTime() );

        return database;
    }

    @Override
    public DatabaseDto toDto(Database arg0) {
        if ( arg0 == null ) {
            return null;
        }

        DatabaseDto databaseDto = new DatabaseDto();

        databaseDto.setId( arg0.getId() );
        databaseDto.setName( arg0.getName() );
        databaseDto.setJdbcUrl( arg0.getJdbcUrl() );
        databaseDto.setPwd( arg0.getPwd() );
        databaseDto.setUserName( arg0.getUserName() );
        databaseDto.setCreateTime( arg0.getCreateTime() );

        return databaseDto;
    }

    @Override
    public List<Database> toEntity(List<DatabaseDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Database> list = new ArrayList<Database>( arg0.size() );
        for ( DatabaseDto databaseDto : arg0 ) {
            list.add( toEntity( databaseDto ) );
        }

        return list;
    }

    @Override
    public List<DatabaseDto> toDto(List<Database> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<DatabaseDto> list = new ArrayList<DatabaseDto>( arg0.size() );
        for ( Database database : arg0 ) {
            list.add( toDto( database ) );
        }

        return list;
    }
}
