package com.hmn.ym.dao.entity.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "t_cust_shop")
public class CustShop {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 店面名称
     */
    @Column(name = "shop_name")
    private String shopName;

    /**
     * 地址
     */
    @Column(name = "shop_address")
    private String shopAddress;

    /**
     * 店面描述
     */
    @Column(name = "shop_desc")
    private String shopDesc;

    /**
     * 店面负责人名称
     */
    @Column(name = "shop_user_name")
    private String shopUserName;

    /**
     * 手机电话
     */
    @Column(name = "shop_phone")
    private String shopPhone;

    /**
     * 身份证
     */
    @Column(name = "shop_id_card")
    private String shopIdCard;

    /**
     * 1 已签约  2 未签约  3 作废
     */
    @Column(name = "shop_xieyi_status")
    private Integer shopXieyiStatus;

    /**
     * 业务员id t_user
     */
    @Column(name = "bussiness_user_id")
    private Long bussinessUserId;

    /**
     * 店家用户id t_user
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 1 正常  2 不正常
     */
    @Column(name = "shop_status")
    private Integer shopStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建者
     */
    @Column(name = "create_id")
    private Long createId;

    /**
     * 更新者
     */
    @Column(name = "update_id")
    private Long updateId;
}