package com.lcq.app.modules.system.controller;

import com.lcq.app.common.exception.CustomException;
import com.lcq.app.modules.system.controller.vo.ResultVO;
import com.lcq.app.modules.system.entity.SysUserEntity;
import com.lcq.app.modules.system.service.SysUserService;
import com.lcq.app.utils.JwtUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.AbstractController;

import java.io.IOException;
import java.util.Map;

/**
 * @program: app
 * @description: 测试
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@RestController
@RequestMapping("/sys/user")
@Slf4j
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("获取用户信息")
    @GetMapping("/getOne")
    public ResultVO getOne() {
        ResultVO resultVO = new ResultVO();
        SysUserEntity sysUserEntity = sysUserService.getById("694e8809cd22e5b35c0cf0f346a48216");
        resultVO.setCode(0);
        resultVO.setMsg("获取成功");
        resultVO.setData(sysUserEntity);
        log.error("{}",sysUserEntity);
        return resultVO;
    }

    @ApiOperation("新增用户")
    @PostMapping("/create")
    public String create(){
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUsername("adminadmin");
        sysUserEntity.setEmail("2222222@qq.com");
        sysUserEntity.setPicture("aa");
        sysUserEntity.setMobile("13413513600");
        sysUserEntity.setWx_openid("222222");
        sysUserEntity.setStatus(1);
//        String salt = RandomStringUtils.randomAlphanumeric(20);
        sysUserEntity.setPassword(new Sha256Hash("123456", "123456").toHex());
        sysUserService.save(sysUserEntity);
        return "ok";
    }

    @ApiOperation("修改用户")
    @PostMapping("/update")
    public ResultVO update(){
        ResultVO resultVO = new ResultVO();
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setId("ebaf54b537b901566c44b828d736a62b");
        sysUserEntity.setPassword("45678910");
        Boolean flag = sysUserService.updateById(sysUserEntity);
        resultVO.setCode(0);
        resultVO.setMsg("修改成功");
        resultVO.setData(flag);
        log.info("{}",resultVO);
        return resultVO;
    }

    /**
     * 登录
     */
    @ApiOperation("用户登录")
    @PostMapping("login")
    public ResultVO login(@RequestParam String username,@RequestParam String password) {
        ResultVO resultVO = new ResultVO();
        //用户信息
        SysUserEntity user = sysUserService.findByUserName(username);

        //账号不存在、密码错误
        if(user == null || !user.getPassword().equals(new Sha256Hash(password, "123456").toHex())) {
            resultVO.setCode(500);
            resultVO.setMsg("账号或密码不正确");
        }

        //账号锁定
        if(user.getStatus() == 2){
            resultVO.setCode(500);
            resultVO.setMsg("账号已被锁定,请联系管理员");
        }

        //生成token
        String token = JwtUtil.sign(username,password);
        resultVO.setCode(0);
        resultVO.setMsg("登录成功");
        resultVO.setData(token);
        return resultVO;
    }
}
