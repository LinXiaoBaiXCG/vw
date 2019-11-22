package io.github.linxiaobaixcg.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.entity.VwProblem;
import io.github.linxiaobaixcg.oauth2.annotation.Login;
import io.github.linxiaobaixcg.service.VwProblemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @program: app
 * @description:VwProblemController
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@RestController
@RequestMapping("/api/problem")
@Api(tags = "问题操作相关接口")
@Slf4j
public class VwProblemController {

    @Autowired
    private VwProblemService vwProblemService;

    @Login
    @ApiOperation("创建问题")
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody @Validated VwProblem vwProblem, @RequestAttribute("userId") Long userId) {
        vwProblem.setUserId(userId);
        return new ResponseEntity(vwProblemService.addProblem(vwProblem), HttpStatus.CREATED);
    }

    @Login
    @ApiOperation("我的提问列表")
    @GetMapping("/userProblem")
    public ResponseEntity userProblem(Page page, @RequestAttribute("userId") Long userId) {
        return new ResponseEntity(vwProblemService.getUserProblem(page, userId), HttpStatus.OK);
    }

    @ApiOperation("问题搜索")
    @GetMapping("/search")
    public ResponseEntity search(Page page, String title){
        return new ResponseEntity(vwProblemService.getByTitle(page, title), HttpStatus.OK);
    }
}
