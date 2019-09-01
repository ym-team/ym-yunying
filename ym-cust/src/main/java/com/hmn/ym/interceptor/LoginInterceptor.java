package com.hmn.ym.interceptor;

import com.hmn.ym.common.Constants;
import com.hmn.ym.common.annotation.NotNeedSecurity;
import com.hmn.ym.dao.entities.po.User;
import com.hmn.ym.service.user.IUserService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 管理平台拦截器
 * <p>
 * 包括登录信息、权限信息
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Reference
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            if (handler instanceof HandlerMethod) {
                // 从切点上获取目标方法
                HandlerMethod handlerMethod = (HandlerMethod) handler;

                Method method = handlerMethod.getMethod();
                // 若目标方法忽略了安全性检查，则直接调用目标方法
                if (method.isAnnotationPresent(NotNeedSecurity.class)) {
                    return true;
                }
                User user = (User) request.getSession().getAttribute(Constants.ADMIN_USER_SESSION);
                if (null == user) {
                    // 如果是ajax请求响应头会有，x-requested-with；
                    String header = request.getHeader("x-requested-with");
                    if (header != null && "XMLHttpRequest".equalsIgnoreCase(header)) {
                        response.setHeader("statusCode", "301");// 在响应头设置session状态
                        return false;
                    }
                    request.setAttribute("message", "未登录！");
                    response.sendRedirect(request.getContextPath() + "/login");
                    return false;
                }
            }
        } catch (Exception e) {
            logger.error("权限过滤失败：" + e.getMessage(), e);
        }
        return true;
    }
}