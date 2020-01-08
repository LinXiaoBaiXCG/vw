package io.github.linxiaobaixcg.modules.system.service.mapper;

import io.github.linxiaobaixcg.modules.system.domain.Dict;
import io.github.linxiaobaixcg.modules.system.domain.DictDetail;
import io.github.linxiaobaixcg.modules.system.service.dto.DictDetailDto;
import io.github.linxiaobaixcg.modules.system.service.dto.DictDto;
import io.github.linxiaobaixcg.modules.system.service.dto.DictSmallDto;
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
public class DictMapperImpl implements DictMapper {

    @Override
    public Dict toEntity(DictDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Dict dict = new Dict();

        dict.setId( arg0.getId() );
        dict.setName( arg0.getName() );
        dict.setRemark( arg0.getRemark() );
        dict.setCreateTime( arg0.getCreateTime() );
        dict.setDictDetails( dictDetailDtoListToDictDetailList( arg0.getDictDetails() ) );

        return dict;
    }

    @Override
    public DictDto toDto(Dict arg0) {
        if ( arg0 == null ) {
            return null;
        }

        DictDto dictDto = new DictDto();

        dictDto.setId( arg0.getId() );
        dictDto.setName( arg0.getName() );
        dictDto.setRemark( arg0.getRemark() );
        dictDto.setDictDetails( dictDetailListToDictDetailDtoList( arg0.getDictDetails() ) );
        dictDto.setCreateTime( arg0.getCreateTime() );

        return dictDto;
    }

    @Override
    public List<Dict> toEntity(List<DictDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Dict> list = new ArrayList<Dict>( arg0.size() );
        for ( DictDto dictDto : arg0 ) {
            list.add( toEntity( dictDto ) );
        }

        return list;
    }

    @Override
    public List<DictDto> toDto(List<Dict> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<DictDto> list = new ArrayList<DictDto>( arg0.size() );
        for ( Dict dict : arg0 ) {
            list.add( toDto( dict ) );
        }

        return list;
    }

    protected Dict dictSmallDtoToDict(DictSmallDto dictSmallDto) {
        if ( dictSmallDto == null ) {
            return null;
        }

        Dict dict = new Dict();

        dict.setId( dictSmallDto.getId() );

        return dict;
    }

    protected DictDetail dictDetailDtoToDictDetail(DictDetailDto dictDetailDto) {
        if ( dictDetailDto == null ) {
            return null;
        }

        DictDetail dictDetail = new DictDetail();

        dictDetail.setId( dictDetailDto.getId() );
        dictDetail.setLabel( dictDetailDto.getLabel() );
        dictDetail.setValue( dictDetailDto.getValue() );
        dictDetail.setSort( dictDetailDto.getSort() );
        dictDetail.setDict( dictSmallDtoToDict( dictDetailDto.getDict() ) );
        dictDetail.setCreateTime( dictDetailDto.getCreateTime() );

        return dictDetail;
    }

    protected List<DictDetail> dictDetailDtoListToDictDetailList(List<DictDetailDto> list) {
        if ( list == null ) {
            return null;
        }

        List<DictDetail> list1 = new ArrayList<DictDetail>( list.size() );
        for ( DictDetailDto dictDetailDto : list ) {
            list1.add( dictDetailDtoToDictDetail( dictDetailDto ) );
        }

        return list1;
    }

    protected DictSmallDto dictToDictSmallDto(Dict dict) {
        if ( dict == null ) {
            return null;
        }

        DictSmallDto dictSmallDto = new DictSmallDto();

        dictSmallDto.setId( dict.getId() );

        return dictSmallDto;
    }

    protected DictDetailDto dictDetailToDictDetailDto(DictDetail dictDetail) {
        if ( dictDetail == null ) {
            return null;
        }

        DictDetailDto dictDetailDto = new DictDetailDto();

        dictDetailDto.setId( dictDetail.getId() );
        dictDetailDto.setLabel( dictDetail.getLabel() );
        dictDetailDto.setValue( dictDetail.getValue() );
        dictDetailDto.setSort( dictDetail.getSort() );
        dictDetailDto.setDict( dictToDictSmallDto( dictDetail.getDict() ) );
        dictDetailDto.setCreateTime( dictDetail.getCreateTime() );

        return dictDetailDto;
    }

    protected List<DictDetailDto> dictDetailListToDictDetailDtoList(List<DictDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<DictDetailDto> list1 = new ArrayList<DictDetailDto>( list.size() );
        for ( DictDetail dictDetail : list ) {
            list1.add( dictDetailToDictDetailDto( dictDetail ) );
        }

        return list1;
    }
}
