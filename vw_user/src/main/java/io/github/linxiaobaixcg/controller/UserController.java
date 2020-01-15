package io.github.linxiaobaixcg.controller;

import io.github.linxiaobaixcg.annotation.Login;
import io.github.linxiaobaixcg.entity.Result;
import io.github.linxiaobaixcg.entity.StatusCode;
import io.github.linxiaobaixcg.entity.User;
import io.github.linxiaobaixcg.entity.vo.UpdateCountVO;
import io.github.linxiaobaixcg.entity.vo.UserRegisterVO;
import io.github.linxiaobaixcg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2020-01-03 22:59
 **/
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Login
    @GetMapping
    public Result getUserInfo(@RequestAttribute("userId") String userId){
        return new Result(StatusCode.OK,userService.findUserById(new Long(userId)));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRegisterVO userRegisterVO){
        userService.register(userRegisterVO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){
        return new ResponseEntity(userService.login(user),HttpStatus.OK);
    }

    @PutMapping("/updateFollowCount/{userId}/{count}")
    public ResponseEntity updateFollowCount(@PathVariable("userId")String userId, @PathVariable("count")Integer count){
        userService.updateFollowCount(userId,count);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateFansCount/{userId}/{count}")
    public ResponseEntity updateFansCount(@PathVariable("userId")String userId, @PathVariable("count")Integer count){
        userService.updateFansCount(userId,count);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateProblemCount/{userId}/{count}")
    public ResponseEntity updateProblemCount(@PathVariable("userId")String userId, @PathVariable("count")Integer count){
        userService.updateProblemCount(userId,count);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateAnswerCount/{userId}/{count}")
    public ResponseEntity updateAnswerCount(@PathVariable("userId")String userId, @PathVariable("count")Integer count){
        userService.updateAnswerCount(userId,count);
        return new ResponseEntity(HttpStatus.OK);
    }
}
