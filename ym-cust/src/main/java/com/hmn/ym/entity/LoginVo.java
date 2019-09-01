package com.hmn.ym.entity;

import lombok.Data;

/**
 * 用户登录
 *
 * @author xfz
 */
@Data
public class LoginVo {
    /**
     * 用户名
     */
    private String userAccount;
    /**
     * 密码
     */
    private String userPassword;
}
