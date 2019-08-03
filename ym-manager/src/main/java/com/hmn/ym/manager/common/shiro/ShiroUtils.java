package com.hmn.ym.manager.common.shiro;

import com.hmn.ym.dao.entities.po.system.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;


public final class ShiroUtils {

    /**
     * 获取登录用户
     *
     * @return
     */
    public static User getUser() {
        Subject subject = SecurityUtils.getSubject();
        if (subject == null) {
            return null;
        }
        return (User) subject.getSession().getAttribute("user");
    }

    /**
     * 获取登录用户Id
     *
     * @return
     */
    public static Integer getUserId() {
        Subject subject = SecurityUtils.getSubject();
        if (subject == null) {
            return null;
        }
        return (Integer) subject.getSession().getAttribute("userId");
    }

    /**
     * 获取登录用户名称
     *
     * @return
     */
    public static String getUserName() {
        Subject subject = SecurityUtils.getSubject();
        if (subject == null) {
            return null;
        }
        return (String) subject.getSession().getAttribute("userName");
    }
}
