package io.github.linxiaobaixcg.annotation;

import java.lang.annotation.*;

/**
 * @program: vw
 * @description: 登录校验
 * @author: LCQ
 * @create: 2020-01-03 22:47
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
