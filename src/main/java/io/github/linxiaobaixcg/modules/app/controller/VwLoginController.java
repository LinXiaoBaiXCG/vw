package io.github.linxiaobaixcg.modules.app.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;
import io.github.linxiaobaixcg.common.util.RedisUtils;
import io.github.linxiaobaixcg.common.util.VerifyCodeUtils;
import io.github.linxiaobaixcg.modules.app.entity.VwUser;
import io.github.linxiaobaixcg.modules.app.service.VwUserService;
import io.github.linxiaobaixcg.modules.system.controller.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: app
 * @description:
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@RestController
@RequestMapping("/api")
@Api(tags = "用户登录")
@Slf4j
public class VwLoginController {
    @Autowired
    private VwUserService vwUserService;

    @Autowired
    private RedisUtils redisUtils;

    @Value("${loginCode.expiration}")
    private Long expiration;

    /**
     * APP用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @ApiOperation("用户登录")
    @PostMapping("login")
    public ResultVO login(String username, String password) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("登录成功");
        VwUser vwUser = new VwUser();
        return resultVO;
    }

    @ApiOperation("获取验证码")
    @GetMapping("/verificationCode")
    public ResponseEntity getCode(HttpServletResponse response) throws IOException {
        Map<String, Object> result = new HashMap<>();
        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        String uuid = IdUtil.simpleUUID();
        result.put("uuid", uuid);
        redisUtils.set(uuid, verifyCode,expiration);
        // 生成图片
        int w = 111, h = 36;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(w, h, stream, verifyCode);
        try {
            result.put("img", Base64.encode(stream.toByteArray()));
        } catch (Exception e) {
            log.error("{}", e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            stream.close();
        }
        return ResponseEntity.ok(result);
    }
}
