package io.github.linxiaobaixcg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.linxiaobaixcg.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2020-01-06 22:36
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
