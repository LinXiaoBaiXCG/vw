package io.github.linxiaobaixcg.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.linxiaobaixcg.client.UserClient;
import io.github.linxiaobaixcg.entity.Follow;
import io.github.linxiaobaixcg.entity.vo.FollowUserVO;
import io.github.linxiaobaixcg.mapper.FollowMapper;
import io.github.linxiaobaixcg.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2020-01-09 15:40
 **/
@Service
public class FollowService {

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private UserClient userClient;

    /**
     * 关注用户
     * @param follow
     */
    @Transactional
    public void followUser(Follow follow){
        //添加关注用户记录
        follow.setId(idWorker.nextId()+"");
        follow.setType(1);
        followMapper.insert(follow);
        //更新用户关注数
        userClient.updateFollowCount(follow.getUserId(),1);
        //更新被关注用户粉丝数
        userClient.updateFansCount(follow.getObjectId(),1);
    }

    /**
     * 用户关注问题
     * @param follow
     */
    @Transactional
    public void followProblem(Follow follow){
        //添加关注问题记录
        follow.setId(idWorker.nextId()+"");
        follow.setType(2);
        followMapper.insert(follow);
        //TODO 更新用户关注问题数
        //TODO 更新问题关注数
    }

    /**
     * 获取关注用户列表
     * @param userId
     * @param page
     * @return
     */
    public IPage<FollowUserVO> getFollowUserList(String userId, Page page){
        return followMapper.findFollowUserList(page,userId);
    }
}
