package com.hmn.ym.dao.entity.vo;

import com.hmn.ym.dao.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author xfz
 * @since 2018-05-28
 */
@Data
public class CategoryIndexVo extends BaseEntity {


    /**
     *
     */
    private Long id;

    /**
     *
     */
    private Long categoryId;

    /**
     * 图片地址
     */
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
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建用户id
     */
    private Long userId;

    /**
     * 是否展示前端页面1展示；0不展示
     */
    private Integer isShow;

    /**
     * 前端页面排序
     */
    private Integer isSort;
}
