package io.github.linxiaobaixcg.modules.system.service.mapper;

import io.github.linxiaobaixcg.modules.system.domain.Job;
import io.github.linxiaobaixcg.modules.system.service.dto.JobDto;
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
public class JobMapperImpl implements JobMapper {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Job toEntity(JobDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Job job = new Job();

        job.setId( arg0.getId() );
        job.setName( arg0.getName() );
        job.setSort( arg0.getSort() );
        job.setEnabled( arg0.getEnabled() );
        job.setDept( deptMapper.toEntity( arg0.getDept() ) );
        job.setCreateTime( arg0.getCreateTime() );

        return job;
    }

    @Override
    public JobDto toDto(Job arg0) {
        if ( arg0 == null ) {
            return null;
        }

        JobDto jobDto = new JobDto();

        jobDto.setId( arg0.getId() );
        jobDto.setSort( arg0.getSort() );
        jobDto.setName( arg0.getName() );
        jobDto.setEnabled( arg0.getEnabled() );
        jobDto.setDept( deptMapper.toDto( arg0.getDept() ) );
        jobDto.setCreateTime( arg0.getCreateTime() );

        return jobDto;
    }

    @Override
    public List<Job> toEntity(List<JobDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Job> list = new ArrayList<Job>( arg0.size() );
        for ( JobDto jobDto : arg0 ) {
            list.add( toEntity( jobDto ) );
        }

        return list;
    }

    @Override
    public List<JobDto> toDto(List<Job> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<JobDto> list = new ArrayList<JobDto>( arg0.size() );
        for ( Job job : arg0 ) {
            list.add( toDto( job ) );
        }

        return list;
    }

    @Override
    public JobDto toDto(Job job, String deptSuperiorName) {
        if ( job == null && deptSuperiorName == null ) {
            return null;
        }

        JobDto jobDto = new JobDto();

        if ( job != null ) {
            jobDto.setId( job.getId() );
            jobDto.setSort( job.getSort() );
            jobDto.setName( job.getName() );
            jobDto.setEnabled( job.getEnabled() );
            jobDto.setDept( deptMapper.toDto( job.getDept() ) );
            jobDto.setCreateTime( job.getCreateTime() );
        }
        if ( deptSuperiorName != null ) {
            jobDto.setDeptSuperiorName( deptSuperiorName );
        }

        return jobDto;
    }
}
