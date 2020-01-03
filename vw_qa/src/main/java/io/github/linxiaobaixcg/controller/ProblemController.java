package io.github.linxiaobaixcg.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.annotation.Login;
import io.github.linxiaobaixcg.entity.Problem;
import io.github.linxiaobaixcg.entity.Result;
import io.github.linxiaobaixcg.entity.StatusCode;
import io.github.linxiaobaixcg.service.ProblemService;
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
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @Login
    @PostMapping
    public Result add(@RequestAttribute("userId") String userId, @RequestBody @Validated Problem problem){
        problem.setUserId(userId);
        problemService.insert(problem);
        return new Result(StatusCode.OK);
    }

    @Login
    @GetMapping(value = "/getAll")
    public Result getAll(@RequestAttribute("userId") String userId, Page page){
        return new Result(StatusCode.OK,problemService.findByUserId(userId,page));
    }
}
