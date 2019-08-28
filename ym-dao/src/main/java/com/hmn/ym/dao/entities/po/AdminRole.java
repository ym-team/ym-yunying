package com.hmn.ym.dao.entities.po;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Table(name = "t_sys_admin_role")
@Getter@Setter
public class AdminRole implements Serializable {
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

    private static final long serialVersionUID = 1L;
}