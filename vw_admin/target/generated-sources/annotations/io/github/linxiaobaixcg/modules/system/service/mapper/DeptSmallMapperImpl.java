package io.github.linxiaobaixcg.modules.system.service.mapper;

import io.github.linxiaobaixcg.modules.system.domain.Dept;
import io.github.linxiaobaixcg.modules.system.service.dto.DeptSmallDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-09T16:30:41+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class DeptSmallMapperImpl implements DeptSmallMapper {

    @Override
    public Dept toEntity(DeptSmallDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Dept dept = new Dept();

        dept.setId( arg0.getId() );
        dept.setName( arg0.getName() );

        return dept;
    }

    @Override
    public DeptSmallDto toDto(Dept arg0) {
        if ( arg0 == null ) {
            return null;
        }

        DeptSmallDto deptSmallDto = new DeptSmallDto();

        deptSmallDto.setId( arg0.getId() );
        deptSmallDto.setName( arg0.getName() );

        return deptSmallDto;
    }

    @Override
    public List<Dept> toEntity(List<DeptSmallDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Dept> list = new ArrayList<Dept>( arg0.size() );
        for ( DeptSmallDto deptSmallDto : arg0 ) {
            list.add( toEntity( deptSmallDto ) );
        }

        return list;
    }

    @Override
    public List<DeptSmallDto> toDto(List<Dept> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<DeptSmallDto> list = new ArrayList<DeptSmallDto>( arg0.size() );
        for ( Dept dept : arg0 ) {
            list.add( toDto( dept ) );
        }

        return list;
    }
}
