package io.github.linxiaobaixcg.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.linxiaobaixcg.modules.app.entity.VwAnswer;
import io.github.linxiaobaixcg.modules.app.entity.VwFollow;
import io.github.linxiaobaixcg.modules.app.service.VwFollowService;
import io.github.linxiaobaixcg.modules.system.controller.vo.ResultVO;
import io.github.linxiaobaixcg.modules.app.repository.VwFollowRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: app
 * @description: VwFollowServiceImpl
 * @author: LCQ
 * @create: 2019-05-20 23:28
 **/
@Service
public class VwFollowServiceImpl extends ServiceImpl<VwFollowRepository, VwFollow> implements VwFollowService {

    private final VwFollowRepository vwFollowRepository;

    public VwFollowServiceImpl(VwFollowRepository vwFollowRepository) {
        this.vwFollowRepository = vwFollowRepository;
    }

    @Override
    public IPage<VwFollow> getPageByUserId(Page page, String userId) {
        return vwFollowRepository.getPageByUserId(page,userId);
    }

    /*
    * 获取我的关注人的文章列表
    */
    @Override
    public IPage<VwAnswer> answerPage(Page page, String userId){
        ResultVO resultVO = new ResultVO();
        //获取我的关注人
        QueryWrapper<VwFollow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        List<VwFollow> vwFollows = vwFollowRepository.selectList(queryWrapper);
        //遍历出我关注的人
        List<String> strings = new ArrayList<>();
        vwFollows.forEach(obj ->{
            String concernedId =obj.getConcernedId();
            strings.add(concernedId);
        });
        IPage<VwAnswer> vwFollowIPage = vwFollowRepository.answerPage(page,userId,strings);
        return vwFollowIPage;
    }


}
