package com.hmn.ym.dao.entities.po.system;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "t_sys_user_role")
@Getter
@Setter
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户ID(t_sys_user.id)
     */
    @Column(name = "user_id")
    private Integer userId;
    /**
     * 角色id(t_sys_role.id)
     */
    @Column(name = "role_id")
    private Integer roleId;
}