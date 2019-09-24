package io.github.linxiaobaixcg.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.common.util.RedisUtils;
import io.github.linxiaobaixcg.modules.app.entity.VwAnswer;
import io.github.linxiaobaixcg.modules.app.repository.VwAnswerRepository;
import io.github.linxiaobaixcg.modules.app.service.VwAnswerService;
import io.github.linxiaobaixcg.modules.app.service.dto.VwAnswerDTO;
import io.github.linxiaobaixcg.modules.app.service.dto.VwAnswerQueryCriteria;
import io.github.linxiaobaixcg.modules.app.service.dto.VwUserAgreeDTO;
import io.lettuce.core.cluster.RedisAdvancedClusterAsyncCommandsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: app
 * @description: VwAnswerServiceImpl
 * @author: LCQ
 * @create: 2019-05-20 23:28
 **/
@Service
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
        Object answerUuid = redisUtils.get("userAgree" + userUuid);
        if (vwAnswerDTO.getUuid().equals(answerUuid)) {
            vwAnswerDTO.setUserIsAgree(true);
        } else {
            vwAnswerDTO.setUserIsAgree(false);
        }
        //获取回答点赞数
        Object agreeCount = redisUtils.get("agree" + vwAnswerDTO.getUuid());
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
            redisUtils.set("userAgree" + userUuid, uuid);
            redisUtils.incr("agree" + uuid, 1);
            vwUserAgreeDTO.setUserIsAgree(true);
        }
        if (!userIsAgree) {
            redisUtils.del("userAgree" + userUuid, uuid);
            redisUtils.decr("agree" + uuid, 1);
            vwUserAgreeDTO.setUserIsAgree(false);
        }
        return vwUserAgreeDTO;
    }
}
