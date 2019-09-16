package io.github.linxiaobaixcg.modules.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.linxiaobaixcg.modules.app.entity.VwProblem;

/**
 * @program: app
 * @description: VwProblemService
 * @author: LCQ
 * @create: 2019-05-20 23:26
 **/
public interface VwProblemService extends IService<VwProblem> {
    IPage<VwProblem> getListByTitle(Page page, String title);
}
