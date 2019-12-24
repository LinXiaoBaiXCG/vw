package io.github.linxiaobaixcg.modules.system.service.mapper;

import io.github.linxiaobaixcg.modules.system.domain.Dept;
import io.github.linxiaobaixcg.modules.system.service.dto.DeptDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-25T00:21:24+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class DeptMapperImpl implements DeptMapper {

    @Override
    public Dept toEntity(DeptDto dto) {
        if ( dto == null ) {
            return null;
        }

        Dept dept = new Dept();

        dept.setId( dto.getId() );
        dept.setName( dto.getName() );
        dept.setEnabled( dto.getEnabled() );
        dept.setPid( dto.getPid() );
        dept.setCreateTime( dto.getCreateTime() );

        return dept;
    }

    @Override
    public DeptDto toDto(Dept entity) {
        if ( entity == null ) {
            return null;
        }

        DeptDto deptDto = new DeptDto();

        deptDto.setId( entity.getId() );
        deptDto.setName( entity.getName() );
        deptDto.setEnabled( entity.getEnabled() );
        deptDto.setPid( entity.getPid() );
        deptDto.setCreateTime( entity.getCreateTime() );

        return deptDto;
    }

    @Override
    public List<Dept> toEntity(List<DeptDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Dept> list = new ArrayList<Dept>( dtoList.size() );
        for ( DeptDto deptDto : dtoList ) {
            list.add( toEntity( deptDto ) );
        }

        return list;
    }

    @Override
    public List<DeptDto> toDto(List<Dept> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DeptDto> list = new ArrayList<DeptDto>( entityList.size() );
        for ( Dept dept : entityList ) {
            list.add( toDto( dept ) );
        }

        return list;
    }
}
