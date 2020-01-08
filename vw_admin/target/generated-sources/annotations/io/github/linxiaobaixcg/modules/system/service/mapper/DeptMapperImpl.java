package io.github.linxiaobaixcg.modules.system.service.mapper;

import io.github.linxiaobaixcg.modules.system.domain.Dept;
import io.github.linxiaobaixcg.modules.system.service.dto.DeptDto;
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
public class DeptMapperImpl implements DeptMapper {

    @Override
    public Dept toEntity(DeptDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Dept dept = new Dept();

        dept.setId( arg0.getId() );
        dept.setName( arg0.getName() );
        dept.setEnabled( arg0.getEnabled() );
        dept.setPid( arg0.getPid() );
        dept.setCreateTime( arg0.getCreateTime() );

        return dept;
    }

    @Override
    public DeptDto toDto(Dept arg0) {
        if ( arg0 == null ) {
            return null;
        }

        DeptDto deptDto = new DeptDto();

        deptDto.setId( arg0.getId() );
        deptDto.setName( arg0.getName() );
        deptDto.setEnabled( arg0.getEnabled() );
        deptDto.setPid( arg0.getPid() );
        deptDto.setCreateTime( arg0.getCreateTime() );

        return deptDto;
    }

    @Override
    public List<Dept> toEntity(List<DeptDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Dept> list = new ArrayList<Dept>( arg0.size() );
        for ( DeptDto deptDto : arg0 ) {
            list.add( toEntity( deptDto ) );
        }

        return list;
    }

    @Override
    public List<DeptDto> toDto(List<Dept> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<DeptDto> list = new ArrayList<DeptDto>( arg0.size() );
        for ( Dept dept : arg0 ) {
            list.add( toDto( dept ) );
        }

        return list;
    }
}
