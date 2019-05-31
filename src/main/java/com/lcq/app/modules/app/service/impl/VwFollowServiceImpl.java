package com.lcq.app.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcq.app.common.exception.CustomException;
import com.lcq.app.modules.app.entity.VwFollow;
import com.lcq.app.modules.app.repository.VwFollowRepository;
import com.lcq.app.modules.app.service.VwFollowService;
import org.springframework.stereotype.Service;

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
}
