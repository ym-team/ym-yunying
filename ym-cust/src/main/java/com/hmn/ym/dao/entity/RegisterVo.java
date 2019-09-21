package com.hmn.ym.dao.entity;

import lombok.Data;

@Data
public class RegisterVo {
    private String userPassword;

    private String inviteUserid;

    private String smsRand;

    private String userAccount;

    private String userPhone;

    private String publickey;

    private String passwordr;
}
