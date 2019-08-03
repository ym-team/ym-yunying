package com.hmn.ym.dao.entities.po.system;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_sys_role_permission")
@Getter
@Setter
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;
    /**
     * 权限ID
     */
    @Column(name = "permission_id")
    private Integer permissionId;
    /**
     * 创建人Id
     */
    @Column(name = "create_id")
    private Integer createId;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
}