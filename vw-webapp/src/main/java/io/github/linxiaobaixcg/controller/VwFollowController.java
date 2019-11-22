package io.github.linxiaobaixcg.controller;

import io.github.linxiaobaixcg.service.VwFollowService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: app
 * @description:VwFollowController
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@RestController
@RequestMapping("/app/vw/follow")
@Api(tags = "关注操作相关接口")
@Slf4j
public class VwFollowController {

    @Autowired
    VwFollowService vwFollowService;

}
