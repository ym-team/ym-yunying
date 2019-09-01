package com.hmn.ym.manager.common.shiro;

import com.hmn.ym.dao.entities.vo.ShiroUser;
import org.apache.shiro.SecurityUtils;


public final class ShiroUtils {

    /**
     * 获取登录用户
     *
     * @return
     */
    public static ShiroUser getUser() {
        ShiroUser subject = (ShiroUser) SecurityUtils.getSubject();
        if (subject == null) {
            return null;
        }
        return subject;
    }

    /**
     * 获取登录用户Id
     *
     * @return
     */
    public static Integer getUserId() {
        ShiroUser subject = (ShiroUser) SecurityUtils.getSubject();
        if (subject == null) {
            return null;
        }
        return subject.getId();
    }

    /**
     * 获取登录用户名称
     *
     * @return
     */
    public static String getUserName() {
        ShiroUser subject = (ShiroUser) SecurityUtils.getSubject();
        if (subject == null) {
            return null;
        }
        return subject.getName();
    }
}
