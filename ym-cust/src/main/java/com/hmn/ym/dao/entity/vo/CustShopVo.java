package com.hmn.ym.dao.entity.vo;

import com.hmn.ym.dao.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author xfz
 * @since 2018-05-28
 */
@Data
public class CustShopVo extends BaseEntity {
    /**
     * 店面名称
     */
    private String shopName;

    /**
     * 地址
     */
    private String shopAddress;

    /**
     * 店面描述
     */
    private String shopDesc;

    /**
     * 店面负责人名称
     */
    private String shopUserName;

    /**
     * 手机电话
     */
    private String shopPhone;

    /**
     * 身份证
     */
    private String shopIdCard;

    /**
     * 1 已签约  2 未签约  3 作废
     */
    private Integer shopXieyiStatus;

    /**
     * 业务员id t_user
     */
    private Long bussinessUserId;

    /**
     * 店家用户id t_user
     */
    private Long userId;

    /**
     * 1 正常  2 不正常
     */
    private Integer shopStatus;

    /**
     * 备注
     */
    private String remark;
}
