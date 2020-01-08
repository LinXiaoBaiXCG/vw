package io.github.linxiaobaixcg.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.annotation.Login;
import io.github.linxiaobaixcg.entity.Agree;
import io.github.linxiaobaixcg.entity.Answer;
import io.github.linxiaobaixcg.entity.Result;
import io.github.linxiaobaixcg.entity.StatusCode;
import io.github.linxiaobaixcg.service.AgreeService;
import io.github.linxiaobaixcg.service.AnswerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2019-12-23 20:52
 **/
@RestController
@RequestMapping(value = "/api/agree")

@Api(tags = "部门模块接口", description = "后台管理服务部门模块接口")
public class AgreeController {

    @Autowired
    private AgreeService agreeService;

    @Login
    @PutMapping
    private Result agreeAnswer(@RequestAttribute("userId") String userId, @RequestBody Agree agree){
        agree.setUserId(userId);
        agreeService.agreeAnswer(agree);
        return new Result(StatusCode.OK);
    }

}
