package com.lcq.app.modules.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lcq.app.modules.app.entity.VwAgree;
import com.lcq.app.modules.app.entity.VwAnswer;
import com.lcq.app.modules.app.entity.VwFollow;
import org.apache.ibatis.annotations.Param;

/**
 * @program: app
 * @description: VwFollowService
 * @author: LCQ
 * @create: 2019-05-20 23:26
 **/
public interface VwFollowService extends IService<VwFollow> {

    /*
     *获取我的关注列表
     */
    IPage<VwFollow> getPageByUserId(Page page, String userId);

    /*
     * 获取我的关注人的文章列表
     */
    IPage<VwAnswer> answerPage(Page page, String userId);
}
