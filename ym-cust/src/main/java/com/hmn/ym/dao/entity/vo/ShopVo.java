package com.hmn.ym.dao.entity.vo;

import com.hmn.ym.dao.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 店铺
 * </p>
 *
 * @author xfz
 * @since 2018-05-28
 */
@Data
public class ShopVo extends BaseEntity {
    /**
     * 店铺名
     */
    private String name;
    /**
     * 店铺地址
     */
    private String address;

    /**
     * 店铺简介
     */
    private String remark;
    /**
     * 店铺电话
     */
    private String phone;
}
