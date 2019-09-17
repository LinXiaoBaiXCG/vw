package io.github.linxiaobaixcg.modules.app.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: app
 * @description:
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@Controller
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

    @Value("${wx.appid}")
    private String appId;

    @Value("${wx.appsecret}")
    private String appsecret;

    @Value("${wx.redirect-uri}")
    private String redirectUri;

    /**
     * APP用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public ResultVO login(String username, String password) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("登录成功");
        VwUser vwUser = new VwUser();
        return resultVO;
    }

    @ApiOperation("获取验证码")
    @GetMapping("/verificationCode")
    @ResponseBody
    public ResponseEntity getCode(HttpServletResponse response) throws IOException {
        Map<String, Object> result = new HashMap<>();
        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        String uuid = IdUtil.simpleUUID();
        result.put("uuid", uuid);
        redisUtils.set(uuid, verifyCode, expiration);
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

    @ApiOperation("微信登录")
    @GetMapping("/wxLogin")
    public void wxLogin(HttpServletResponse response) throws IOException {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + this.appId + "&redirect_uri=" + URLEncoder.encode(this.redirectUri, "UTF-8")
                + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
        response.sendRedirect(url);
    }

    @RequestMapping("/callBack")
    public void callBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取code
        String code = request.getParameter("code");
        //获取accessToken、openid
        String accessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + this.appId + "&secret=SECRET&code=" + code + "&grant_type=authorization_code";
        String result = HttpUtil.get(accessTokenUrl);
        JSONObject jsonObject = JSONUtil.parseObj(result);
        String accessToken = jsonObject.getStr("access_token");
        String openid = jsonObject.getStr("openid");
        //获取用户信息
        String userInfo = HttpUtil.get("https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openid + "&lang=zh_CN");
        response.sendRedirect("/");
    }


}
