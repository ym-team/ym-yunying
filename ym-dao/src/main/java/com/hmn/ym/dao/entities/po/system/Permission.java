package com.hmn.ym.dao.entities.po.system;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_sys_permission")
@Getter
@Setter
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 按钮名称
     */
    private String name;
    /**
     * 按钮编码
     */
    private String code;
    /**
     * 按钮url
     */
    private String url;
    /**
     * 菜单ID
     */
    @Column(name = "menu_id")
    private Integer menuId;
    /**
     * 创建人ID
     */
    @Column(name = "create_id")
    private Integer createId;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 更新人ID
     */
    @Column(name = "update_id")
    private Integer updateId;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;
}