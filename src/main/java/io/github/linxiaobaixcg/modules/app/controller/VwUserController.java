package io.github.linxiaobaixcg.modules.app.controller;

import io.github.linxiaobaixcg.modules.app.entity.vo.UserRegisterVo;
import io.github.linxiaobaixcg.modules.app.service.VwUserService;
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
 * @description:
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@RestController
@RequestMapping("/api/user")
@Api(tags = "用户相关接口")
@Slf4j
public class VwUserController {

    @Autowired
    private VwUserService vwUserService;

    /**
     * 用户注册
     *
     * @param userRegisterVo
     * @return
     */
    @ApiOperation("用户注册")
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity register(@RequestBody @Validated UserRegisterVo userRegisterVo) {
        vwUserService.register(userRegisterVo);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
