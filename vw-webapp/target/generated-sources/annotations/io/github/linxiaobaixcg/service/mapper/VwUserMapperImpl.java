package io.github.linxiaobaixcg.service.mapper;

import io.github.linxiaobaixcg.entity.VwUser;
import io.github.linxiaobaixcg.service.dto.VwUserDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-11-22T21:02:57+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class VwUserMapperImpl implements VwUserMapper {

    @Override
    public VwUser toEntity(VwUserDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        VwUser vwUser = new VwUser();

        vwUser.setUsername( arg0.getUsername() );
        vwUser.setAvatar( arg0.getAvatar() );

        return vwUser;
    }

    @Override
    public VwUserDTO toDto(VwUser arg0) {
        if ( arg0 == null ) {
            return null;
        }

        VwUserDTO vwUserDTO = new VwUserDTO();

        vwUserDTO.setUsername( arg0.getUsername() );
        vwUserDTO.setAvatar( arg0.getAvatar() );

        return vwUserDTO;
    }

    @Override
    public List<VwUser> toEntity(List<VwUserDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<VwUser> list = new ArrayList<VwUser>( arg0.size() );
        for ( VwUserDTO vwUserDTO : arg0 ) {
            list.add( toEntity( vwUserDTO ) );
        }

        return list;
    }

    @Override
    public List<VwUserDTO> toDto(List<VwUser> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<VwUserDTO> list = new ArrayList<VwUserDTO>( arg0.size() );
        for ( VwUser vwUser : arg0 ) {
            list.add( toDto( vwUser ) );
        }

        return list;
    }
}
