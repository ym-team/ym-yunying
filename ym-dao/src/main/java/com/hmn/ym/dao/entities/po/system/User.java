package com.hmn.ym.dao.entities.po.system;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_sys_user")
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 邮箱帐号
     */
    private String email;
    /**
     * 用户类型（1：管理员，2：普通用户）
     */
    private Boolean type;
    /**
     * 状态( 0：禁用  1：启用 )
     */
    private Boolean status;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;
}