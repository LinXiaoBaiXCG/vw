package io.lcq.app.modules.system.oauth2;

import io.lcq.app.modules.system.entity.SysUserDO;
import io.lcq.app.modules.system.service.SysUserService;
import io.lcq.app.common.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


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
        String username = JwtUtils.getUsername(principals.toString());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取角色
        Set<String> roles = new HashSet<String>();


        //获取权限（根据角色查询权限表）
        Set<String> permissions = new HashSet<String>();


        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtils.getUsername(token);
        if (username == null){
            throw new AuthenticationException("token无效，请重新登录");
        }
        SysUserDO sysUser = sysUserService.findByUserName(username);
        if (sysUser == null){
            throw new UnknownAccountException("用户"+username+"不存在!");
        }

        if (sysUser.getStatus() == 2){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sysUser.getUsername(),sysUser.getPassword(),getName());
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(sysUser.getHex()));
        return simpleAuthenticationInfo;
    }
}
