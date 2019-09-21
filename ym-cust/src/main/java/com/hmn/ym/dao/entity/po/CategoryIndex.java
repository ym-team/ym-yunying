package com.hmn.ym.dao.entity.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Table(name = "t_category_index")
public class CategoryIndex {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 图片地址
     */
    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 状态1有效；0无效
     */
    private Integer status;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 描述
     */
    private String descriptor;

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

    /**
     * 创建用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 是否展示前端页面1展示；0不展示
     */
    @Column(name = "is_show")
    private Integer isShow;

    /**
     * 前端页面排序
     */
    @Column(name = "is_sort")
    private Integer isSort;
}