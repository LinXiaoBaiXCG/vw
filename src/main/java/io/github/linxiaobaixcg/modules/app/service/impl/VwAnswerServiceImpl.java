package io.github.linxiaobaixcg.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.common.constant.RedisConstant;
import io.github.linxiaobaixcg.common.util.RedisUtils;
import io.github.linxiaobaixcg.modules.app.entity.VwAnswer;
import io.github.linxiaobaixcg.modules.app.repository.VwAnswerRepository;
import io.github.linxiaobaixcg.modules.app.service.VwAnswerService;
import io.github.linxiaobaixcg.modules.app.service.dto.VwAnswerDTO;
import io.github.linxiaobaixcg.modules.app.service.dto.VwAnswerQueryCriteria;
import io.github.linxiaobaixcg.modules.app.service.dto.VwUserAgreeDTO;
import io.lettuce.core.cluster.RedisAdvancedClusterAsyncCommandsImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: app
 * @description: VwAnswerServiceImpl
 * @author: LCQ
 * @create: 2019-05-20 23:28
 **/
@Service
@Slf4j
public class VwAnswerServiceImpl implements VwAnswerService {

    @Autowired
    private VwAnswerRepository vwAnswerRepository;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public IPage<VwAnswerDTO> getPage(Page page, VwAnswerQueryCriteria queryCriteria) {
        return vwAnswerRepository.getPage(page, queryCriteria);
    }

    @Override
    public int insert(VwAnswer vwAnswer) {
        return vwAnswerRepository.insert(vwAnswer);
    }

    @Override
    public VwAnswerDTO findOne(Long id, String userUuid) {
        VwAnswerDTO vwAnswerDTO = vwAnswerRepository.findOne(id);
        //查询问题回答数
        QueryWrapper<VwAnswer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("problem_id", vwAnswerDTO.getProblemId());
        queryWrapper.eq("is_deleted", 0);
        vwAnswerDTO.setProblemCount(vwAnswerRepository.selectCount(queryWrapper));
        //查询该用户是否点赞
        Object answerUuid = redisUtils.get(vwAnswerDTO.getUuid() + userUuid);
        if (vwAnswerDTO.getUuid().equals(answerUuid)) {
            vwAnswerDTO.setUserIsAgree(true);
        } else {
            vwAnswerDTO.setUserIsAgree(false);
        }
        //获取回答点赞数
        Object agreeCount = redisUtils.get(RedisConstant.AGREE_ANSWER + vwAnswerDTO.getUuid());
        if (null == agreeCount) {
            vwAnswerDTO.setAgreeCount(0L);
        } else {
            vwAnswerDTO.setAgreeCount(new Long(agreeCount.toString()));
        }
        return vwAnswerDTO;
    }

    @Override
    public VwUserAgreeDTO agree(String uuid, Boolean userIsAgree, String userUuid) {
        VwUserAgreeDTO vwUserAgreeDTO = new VwUserAgreeDTO();
        if (userIsAgree) {
            //设置用户点赞标识
            redisUtils.set(uuid + userUuid, uuid);
            //记录用户数
            Long agreeCount = redisUtils.incr(RedisConstant.AGREE_ANSWER + uuid, 1);
            //返回该回答赞同数和用户是否点赞
            vwUserAgreeDTO.setAgreeCount(agreeCount);
            vwUserAgreeDTO.setUserIsAgree(true);
        }
        if (!userIsAgree) {
            redisUtils.del(uuid + userUuid, uuid);
            Long agreeCount = redisUtils.decr(RedisConstant.AGREE_ANSWER + uuid, 1);
            vwUserAgreeDTO.setAgreeCount(agreeCount);
            vwUserAgreeDTO.setUserIsAgree(false);
        }
        return vwUserAgreeDTO;
    }

    @Override
    public IPage<VwAnswerDTO> getMyAnswer(Page page, Long userId) {
        return vwAnswerRepository.findMyAnswer(page,userId);
    }
}
