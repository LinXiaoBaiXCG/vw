package io.github.linxiaobaixcg.controller;

import io.github.linxiaobaixcg.entity.VwUser;
import io.github.linxiaobaixcg.entity.vo.UserRegisterVo;
import io.github.linxiaobaixcg.oauth2.annotation.Login;
import io.github.linxiaobaixcg.service.VwUserService;
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

    @Login
    @GetMapping("/getUserInfo")
    @ApiOperation("获取用户信息")
    public ResponseEntity getUserInfo(@RequestAttribute("userId") Long userId){
        return ResponseEntity.ok(vwUserService.findUserInfo(userId));
    }

    @Login
    @PutMapping("/updateUserInfo")
    @ApiOperation("修改用户信息")
    public ResponseEntity update(@RequestBody @Validated VwUser vwUser){
        vwUserService.updateUserInfo(vwUser);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}