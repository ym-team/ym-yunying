package com.hmn.ym.dao.entities.po.system;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_sys_menu")
@Getter
@Setter
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 菜单编码
     */
    private String code;
    /**
     * 菜单名
     */
    private String name;
    /**
     * 菜单URL
     */
    private String action;
    /**
     * 父菜单id
     */
    @Column(name = "parent_id")
    private Integer parentId;
    /**
     * 0:无效、1有效
     */
    private Byte status;
    /**
     * 菜单深度
     */
    private Integer level;
    /**
     * 排序
     */
    private Integer sort;
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