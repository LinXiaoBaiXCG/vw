package io.github.linxiaobaixcg.controller;

import io.github.linxiaobaixcg.annotation.Login;
import io.github.linxiaobaixcg.entity.Result;
import io.github.linxiaobaixcg.entity.StatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2020-01-03 22:59
 **/
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Login
    @GetMapping
    public Result getUserInfo(@RequestAttribute("userId") String userId){
        return new Result(StatusCode.OK,userId);
    }
}
