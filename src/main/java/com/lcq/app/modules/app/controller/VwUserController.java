package com.lcq.app.modules.app.controller;

import com.lcq.app.modules.app.service.VwUserService;
import com.lcq.app.modules.system.controller.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: app
 * @description:
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@RestController
@RequestMapping("/vw/user")
@Api(description = "用户相关接口")
@Slf4j
public class VwUserController{
    @Autowired
    private VwUserService vwUserService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @ApiOperation("用户登录")
    @PostMapping("login")
    public ResultVO login(String username, String password) {
        ResultVO resultVO = new ResultVO();

        return resultVO;
    }
}
