package com.lcq.app.modules.system.controller;

import com.lcq.app.modules.system.entity.SysUserEntity;
import com.lcq.app.modules.system.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/sys_user")
@Slf4j
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/getOne")
    public SysUserEntity getOne() {
        SysUserEntity sysUserEntity = sysUserService.getById(new Integer(1).toString());
        log.error("{}",sysUserEntity);
        return sysUserEntity;
    }
}
