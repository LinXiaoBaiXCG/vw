package io.github.linxiaobaixcg.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.entity.VwProblem;

/**
 * @program: app
 * @description: VwProblemService
 * @author: LCQ
 * @create: 2019-05-20 23:26
 **/
public interface VwProblemService {
    /**
     * 获取用户提问
     * @param page
     * @param userId
     * @return
     */
    IPage<VwProblem> getUserProblem(Page page, Long userId);

    /**
     * 添加问题
     * @param vwProblem
     * @return
     */
    int addProblem(VwProblem vwProblem);

    /**
     * 通过标题获取问题列表
     * @param page
     * @param title
     * @return
     */
    IPage<VwProblem> getByTitle(Page page, String title);
}
