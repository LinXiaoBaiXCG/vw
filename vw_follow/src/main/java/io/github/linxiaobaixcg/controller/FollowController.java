package io.github.linxiaobaixcg.controller;

import io.github.linxiaobaixcg.annotation.Login;
import io.github.linxiaobaixcg.entity.Follow;
import io.github.linxiaobaixcg.service.FollowService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2020-01-09 15:40
 **/
@Api(tags = "关注相关接口")
@RequestMapping("/api/follow")
@RestController
public class FollowController {

    @Autowired
    private FollowService followService;

    @Login
    @PostMapping("/followUser")
    public ResponseEntity followUser(@RequestAttribute("userId") String userId, @RequestBody Follow follow){
        follow.setUserId(userId);
        followService.followUser(follow);
        return new ResponseEntity(HttpStatus.OK);
    }
}
