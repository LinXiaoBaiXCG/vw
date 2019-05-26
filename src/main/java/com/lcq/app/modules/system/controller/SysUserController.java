package com.lcq.app.modules.system.controller;

import com.lcq.app.modules.system.controller.vo.ResultVO;
import com.lcq.app.modules.system.entity.SysUserEntity;
import com.lcq.app.modules.system.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.AbstractController;

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
        SysUserEntity sysUserEntity = sysUserService.getById(new Integer(1).toString());
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
        sysUserEntity.setUsername("22");
        sysUserEntity.setPassword("222");
        sysUserEntity.setEmail("2222222@qq.com");
        sysUserEntity.setPicture("aa");
        sysUserEntity.setMobile("13413513600");
        sysUserEntity.setWx_openid("222222");
        sysUserEntity.setStatus(1);
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
}
