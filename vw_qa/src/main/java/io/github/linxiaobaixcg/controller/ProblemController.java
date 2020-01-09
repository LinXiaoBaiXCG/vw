package io.github.linxiaobaixcg.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.annotation.Login;
import io.github.linxiaobaixcg.entity.Problem;
import io.github.linxiaobaixcg.entity.Result;
import io.github.linxiaobaixcg.entity.StatusCode;
import io.github.linxiaobaixcg.service.ProblemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2019-12-23 20:52
 **/
@RestController
@RequestMapping(value = "/api/problem")
@Api(tags = "提问相关接口")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @ApiOperation(value = "添加提问")
    @Login
    @PostMapping
    public Result add(@RequestAttribute("userId") String userId, @RequestBody @Validated Problem problem){
        problem.setUserId(userId);
        problemService.insert(problem);
        return new Result(StatusCode.OK);
    }

    @ApiOperation(value = "获取用户全部提问")
    @Login
    @GetMapping(value = "/getAll")
    public Result getAll(@RequestAttribute("userId") String userId, Page page){
        return new Result(StatusCode.OK,problemService.findByUserId(userId,page));
    }
}
