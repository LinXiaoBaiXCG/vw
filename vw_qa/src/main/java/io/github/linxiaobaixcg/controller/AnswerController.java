package io.github.linxiaobaixcg.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.annotation.Login;
import io.github.linxiaobaixcg.entity.Answer;
import io.github.linxiaobaixcg.entity.Problem;
import io.github.linxiaobaixcg.entity.Result;
import io.github.linxiaobaixcg.entity.StatusCode;
import io.github.linxiaobaixcg.service.AnswerService;
import io.github.linxiaobaixcg.service.ProblemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value = "/api/answer")
@Api(tags = "回答相关接口")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @ApiOperation(value = "添加回答")
    @Login
    @PostMapping
    public Result add(@RequestAttribute("userId")String userId,@RequestBody @Validated Answer answer){
        answer.setUserId(userId);
        answerService.add(answer);
        return new Result(StatusCode.OK);
    }

    @ApiOperation(value = "获取回答详情")
    @Login
    @GetMapping(value = "/getOne/{answerId}")
    public Result getAll(@PathVariable String answerId, @RequestAttribute("userId") String userId){
        return new Result(StatusCode.OK,answerService.findOne(answerId,userId));
    }

    @ApiOperation(value = "获取推荐列表")
    @GetMapping(value = "/getRecommendList")
    public Result getRecommendList(Page page){
        return new Result(StatusCode.OK,answerService.findRecommendList(page));
    }

    @ApiOperation(value = "获取用户回答列表")
    @Login
    @GetMapping(value = "/getListByUserId")
    public Result getListByUserId(@RequestAttribute("userId") String userId, Page page){
        return new Result(StatusCode.OK,answerService.findListByUserId(userId,page));
    }
}
