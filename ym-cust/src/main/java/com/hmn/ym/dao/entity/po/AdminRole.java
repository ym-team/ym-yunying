package com.hmn.ym.dao.entity.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "t_sys_admin_role")
public class AdminRole {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID(t_sys_user.id)
     */
    @Column(name = "admin_id")
    private Integer adminId;

    /**
     * 角色id(t_sys_role.id)
     */
    @Column(name = "role_id")
    private Integer roleId;
}