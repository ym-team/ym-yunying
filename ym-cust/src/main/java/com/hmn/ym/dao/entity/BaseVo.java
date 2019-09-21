package com.hmn.ym.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户登录
 *
 * @author xfz
 */
@Data
public class BaseVo {
    /**
     * 主键Id
     */
    private Integer id;

    /**
     * 创建人ID
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人Id
     */
    private Integer updateId;
    /**
     * 更新时间
     */
    private Date updateTime;
}
