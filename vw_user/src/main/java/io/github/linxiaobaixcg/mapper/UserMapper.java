package io.github.linxiaobaixcg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.linxiaobaixcg.entity.User;
import io.github.linxiaobaixcg.entity.vo.UpdateCountVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2020-01-06 22:36
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    void updateFollowCount(UpdateCountVO updateCountVO);

    void updateFansCount(UpdateCountVO updateCountVO);

    void updateProblemCount(UpdateCountVO updateCountVO);

    void updateAnswerCount(UpdateCountVO updateCountVO);
}
