package io.github.linxiaobaixcg.interceptor;

import io.github.linxiaobaixcg.annotation.Login;
import io.github.linxiaobaixcg.exception.BadRequestException;
import io.github.linxiaobaixcg.utils.JwtUtils;
import io.jsonwebtoken.Claims;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限(Token)验证
 *
 * @author Mark sunlightcs@gmail.com
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtUtils jwtUtils;

    public static final String USER_KEY = "userId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        }else{
            return true;
        }

        if(annotation == null){
            return true;
        }

        //获取用户凭证
        String token = request.getHeader(jwtUtils.HEADER);
        if(StringUtils.isBlank(token)){
            token = request.getParameter(jwtUtils.HEADER);
        }

        //凭证为空
        if(StringUtils.isBlank(token)){
            throw new BadRequestException(HttpStatus.UNAUTHORIZED, jwtUtils.HEADER + "不能为空");
        }

        Claims claims = jwtUtils.getClaimByToken(token);
        if(claims == null || jwtUtils.isTokenExpired(claims.getExpiration())){
            throw new BadRequestException(HttpStatus.UNAUTHORIZED,jwtUtils.HEADER + "失效，请重新登录");
        }
        System.out.println(claims.getSubject());
        //设置userId到request里，后续根据userId，获取用户信息
        request.setAttribute(USER_KEY, claims.getSubject());

        return true;
    }
}