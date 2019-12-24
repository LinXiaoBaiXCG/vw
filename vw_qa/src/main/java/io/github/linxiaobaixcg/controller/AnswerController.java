package io.github.linxiaobaixcg.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.entity.Answer;
import io.github.linxiaobaixcg.entity.Problem;
import io.github.linxiaobaixcg.entity.Result;
import io.github.linxiaobaixcg.entity.StatusCode;
import io.github.linxiaobaixcg.service.AnswerService;
import io.github.linxiaobaixcg.service.ProblemService;
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
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping
    public Result add(@RequestBody @Validated Answer answer){
        answerService.add(answer);
        return new Result(StatusCode.OK);
    }

    @GetMapping(value = "/getOne/{id}")
    public Result getAll(@PathVariable String id){
        return new Result(StatusCode.OK,answerService.findOne(id));
    }

    @GetMapping(value = "/getRecommendList")
    public Result getRecommendList(Page page){
        return new Result(StatusCode.OK,answerService.findRecommendList(page));
    }

    @GetMapping(value = "/getListByUserId/{userId}")
    public Result getListByUserId(@PathVariable String userId, Page page){
        return new Result(StatusCode.OK,answerService.findListByUserId(userId,page));
    }
}
