package com.lcq.app.modules.system.controller;

import com.lcq.app.common.util.JwtUtils;
import com.lcq.app.common.util.UUIDUtils;
import com.lcq.app.modules.system.controller.vo.ResultVO;
import com.lcq.app.modules.system.entity.SysUserDO;
import com.lcq.app.modules.system.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        SysUserDO sysUserEntity = sysUserService.getById("6746d0aba65abc3be49f2b79a2517376");
        resultVO.setCode(0);
        resultVO.setMsg("获取成功");
        resultVO.setData(sysUserEntity);
        log.error("{}",sysUserEntity);
        return resultVO;
    }

    @ApiOperation("新增用户")
    @PostMapping("/create")
    public String create(){
        SysUserDO sysUserEntity = new SysUserDO();
        sysUserEntity.setUuid(UUIDUtils.getUUID());
        sysUserEntity.setUsername("admin");
        sysUserEntity.setEmail("2222222@qq.com");
        sysUserEntity.setPicture("aa");
        sysUserEntity.setMobile("13413513600");
        sysUserEntity.setWx_openid("222222");
        sysUserEntity.setStatus(1);
        //生成盐（部分，需要存入数据库中）
        String hex = new SecureRandomNumberGenerator().nextBytes().toHex();
        sysUserEntity.setHex(hex);
        //将原始密码加盐（上面生成的盐），并且用md5算法加密三次，将最后结果存入数据库中
        String hashPassword = new Md5Hash("123456",hex,3).toString();
        sysUserEntity.setPassword(hashPassword);
        sysUserService.save(sysUserEntity);
        return "ok";
    }

    @ApiOperation("修改用户")
    @PostMapping("/update")
    public ResultVO update(){
        ResultVO resultVO = new ResultVO();
        SysUserDO sysUserEntity = new SysUserDO();
        sysUserEntity.setId(1L);
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
    public ResultVO login(String username,String password) {
        ResultVO resultVO = new ResultVO();
        //用户信息
        SysUserDO user = sysUserService.findByUserName(username);
        //账号不存在、密码错误
        if(user == null  || !user.getPassword().equals(new Md5Hash(password,user.getHex(),3).toString())) {
            resultVO.setCode(500);
            resultVO.setMsg("账号或密码不正确");
            return resultVO;
        }

        //账号锁定
        if(user.getStatus() == 2){
            resultVO.setCode(500);
            resultVO.setMsg("账号已被锁定,请联系管理员");
            return resultVO;
        }

        //生成token
        String token = JwtUtils.sign(username,password);
        resultVO.setCode(0);
        resultVO.setMsg("登录成功");
        resultVO.setData(token);
        return resultVO;
    }
}
