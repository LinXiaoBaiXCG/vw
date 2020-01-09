package io.github.linxiaobaixcg.modules.system.service.mapper;

import io.github.linxiaobaixcg.modules.system.domain.DictDetail;
import io.github.linxiaobaixcg.modules.system.service.dto.DictDetailDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-09T16:30:41+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class DictDetailMapperImpl implements DictDetailMapper {

    @Autowired
    private DictSmallMapper dictSmallMapper;

    @Override
    public DictDetail toEntity(DictDetailDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        DictDetail dictDetail = new DictDetail();

        dictDetail.setId( arg0.getId() );
        dictDetail.setLabel( arg0.getLabel() );
        dictDetail.setValue( arg0.getValue() );
        dictDetail.setSort( arg0.getSort() );
        dictDetail.setDict( dictSmallMapper.toEntity( arg0.getDict() ) );
        dictDetail.setCreateTime( arg0.getCreateTime() );

        return dictDetail;
    }

    @Override
    public DictDetailDto toDto(DictDetail arg0) {
        if ( arg0 == null ) {
            return null;
        }

        DictDetailDto dictDetailDto = new DictDetailDto();

        dictDetailDto.setId( arg0.getId() );
        dictDetailDto.setLabel( arg0.getLabel() );
        dictDetailDto.setValue( arg0.getValue() );
        dictDetailDto.setSort( arg0.getSort() );
        dictDetailDto.setDict( dictSmallMapper.toDto( arg0.getDict() ) );
        dictDetailDto.setCreateTime( arg0.getCreateTime() );

        return dictDetailDto;
    }

    @Override
    public List<DictDetail> toEntity(List<DictDetailDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<DictDetail> list = new ArrayList<DictDetail>( arg0.size() );
        for ( DictDetailDto dictDetailDto : arg0 ) {
            list.add( toEntity( dictDetailDto ) );
        }

        return list;
    }

    @Override
    public List<DictDetailDto> toDto(List<DictDetail> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<DictDetailDto> list = new ArrayList<DictDetailDto>( arg0.size() );
        for ( DictDetail dictDetail : arg0 ) {
            list.add( toDto( dictDetail ) );
        }

        return list;
    }
}
