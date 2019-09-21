package com.hmn.ym.dao.entity.vo;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ShiroUser implements Serializable {
    /**
     * 用户Id
     */
    private Integer id;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 用户名
     */
    private String name;

    /**
     * 角色列表
     */
    private List<RoleVo> roleList;

    public ShiroUser(Integer id, String loginName, String name) {
        this.id = id;
        this.loginName = loginName;
        this.name = name;
    }
}
