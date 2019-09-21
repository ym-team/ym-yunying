package com.hmn.ym.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户登录
 *
 * @author xfz
 */
@Data
public class BaseEntity {
    /**
     * 主键Id
     */
    private Integer id;

    /**
     * 创建人ID
     */
    private Integer createId;
    /**
     * 创建人名称
     */
    private Integer createName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人Id
     */
    private Integer updateId;
    /**
     * 更新人名称
     */
    private Integer updateName;
    /**
     * 更新时间
     */
    private Date updateTime;
}
