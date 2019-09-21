package com.hmn.ym.dao.entity.vo;

import com.hmn.ym.dao.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 业务员
 * </p>
 *
 * @author xfz
 * @since 2018-05-28
 */
@Data
public class SalesManVo extends BaseEntity {
    /**
     * 业务员名
     */
    private String name;
    /**
     * 业务员电话
     */
    private String phone;
    /**
     * 业务员地址
     */
    private String address;
    /**
     * 业务员职业
     */
    private String job;
}
