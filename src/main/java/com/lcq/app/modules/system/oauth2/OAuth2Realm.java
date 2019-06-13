package com.lcq.app.modules.system.oauth2;

import com.lcq.app.modules.system.entity.SysUserEntity;
import com.lcq.app.modules.system.oauth2.JwtToken;
import com.lcq.app.modules.system.service.SysUserService;
import com.lcq.app.utils.JwtUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;


    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = JwtUtil.getUsername(principals.toString());
        SysUserEntity user = sysUserService.findByUserName(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token无效，请重新登录");
        }

        SysUserEntity userBean = sysUserService.findByUserName(username);
        if (userBean == null) {
            throw new UnknownAccountException("用户"+username+"不存在!");
        }

        if (!JwtUtil.verify(token, username, userBean.getPassword())) {
            throw new AuthenticationException("用户名或密码错误");
        }

        if (userBean.getStatus() == 2){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        return new SimpleAuthenticationInfo(username, token, "my_realm");
    }
}