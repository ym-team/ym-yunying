package com.hmn.ym.dao.entities.po.system;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_sys_role_menu")
@Getter
@Setter
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
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
     * 菜单id
     */
    @Column(name = "menu_id")
    private Integer menuId;
    /**
     * 创建人
     */
    @Column(name = "create_id")
    private Integer createId;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
}