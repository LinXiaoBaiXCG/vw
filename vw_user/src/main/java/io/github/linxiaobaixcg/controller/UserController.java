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
        return new Result(StatusCode.OK,userService.findUserById(userId));
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

    @PutMapping("/updateFollowCount")
    public ResponseEntity updateFollowCount(@RequestBody UpdateCountVO updateCountVO){
        userService.updateFollowCount(updateCountVO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateFansCount")
    public ResponseEntity updateFansCount(@RequestBody UpdateCountVO updateCountVO){
        userService.updateFansCount(updateCountVO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateProblemCount")
    public ResponseEntity updateProblemCount(@RequestBody UpdateCountVO updateCountVO){
        userService.updateProblemCount(updateCountVO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateAnswerCount")
    public ResponseEntity updateAnswerCount(@RequestBody UpdateCountVO updateCountVO){
        userService.updateAnswerCount(updateCountVO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
