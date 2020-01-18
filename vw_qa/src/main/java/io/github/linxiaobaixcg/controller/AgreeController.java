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
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@Api(tags = "赞同相关接口")
public class AgreeController {

    @Autowired
    private AgreeService agreeService;

    @ApiOperation(value = "赞同回答")
    @Login
    @PutMapping
    private ResponseEntity agreeAnswer(@RequestAttribute("userId") Long userId, @RequestBody Agree agree){
        agree.setUserId(userId);
        agreeService.agreeAnswer(agree);
        return new ResponseEntity(HttpStatus.OK);
    }

}
