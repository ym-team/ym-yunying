package com.hmn.ym.dao.entity.vo;

import lombok.Data;

@Data
public class FindPasswordVo {
    /**
     * 手机号码
     */
    private String userPhone;

    /**
     * 图形验证码
     */
    private String captcha;
    /**
     * 短信验证码
     */
    private String smsCode;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 确认密码
     */
    private String passwordr;
    /**
     * 加密Key
     */
    private String publickey;
}
