package com.lcq.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: app
 * @description: 测试
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@RestController
@RequestMapping("/api")
@Slf4j
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        log.error("Hello!");
        return "Hello!";
    }

//    git add .
//    git commit -m"说明"
//    git push -u origin master
}
