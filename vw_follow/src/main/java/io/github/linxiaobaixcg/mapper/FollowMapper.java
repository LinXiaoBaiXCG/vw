package io.github.linxiaobaixcg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.entity.Follow;
import io.github.linxiaobaixcg.entity.vo.FollowUserVO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2020-01-09 15:39
 **/
@Mapper
public interface FollowMapper extends BaseMapper<Follow> {

    IPage<FollowUserVO> findFollowUserList(Page page,@Param("userId") String userId);
}
