package io.github.linxiaobaixcg.modules.system.service.mapper;

import io.github.linxiaobaixcg.modules.system.domain.Job;
import io.github.linxiaobaixcg.modules.system.service.dto.JobSmallDto;
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
public class JobSmallMapperImpl implements JobSmallMapper {

    @Override
    public Job toEntity(JobSmallDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Job job = new Job();

        job.setId( arg0.getId() );
        job.setName( arg0.getName() );

        return job;
    }

    @Override
    public JobSmallDto toDto(Job arg0) {
        if ( arg0 == null ) {
            return null;
        }

        JobSmallDto jobSmallDto = new JobSmallDto();

        jobSmallDto.setId( arg0.getId() );
        jobSmallDto.setName( arg0.getName() );

        return jobSmallDto;
    }

    @Override
    public List<Job> toEntity(List<JobSmallDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Job> list = new ArrayList<Job>( arg0.size() );
        for ( JobSmallDto jobSmallDto : arg0 ) {
            list.add( toEntity( jobSmallDto ) );
        }

        return list;
    }

    @Override
    public List<JobSmallDto> toDto(List<Job> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<JobSmallDto> list = new ArrayList<JobSmallDto>( arg0.size() );
        for ( Job job : arg0 ) {
            list.add( toDto( job ) );
        }

        return list;
    }
}
