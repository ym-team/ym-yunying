package com.hmn.ym.common.annotation;

import java.lang.annotation.*;

/**
 * 不需要权限检查
 *
 * @author xufz
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNeedSecurity {
}
