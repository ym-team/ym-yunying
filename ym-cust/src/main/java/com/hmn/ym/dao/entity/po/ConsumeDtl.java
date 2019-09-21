package com.hmn.ym.dao.entity.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Table(name = "t_consume_dtl")
public class ConsumeDtl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 项目名称
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 总费用
     */
    @Column(name = "sum_fee")
    private BigDecimal sumFee;

    /**
     * 材料费
     */
    @Column(name = "materials_fee")
    private BigDecimal materialsFee;

    /**
     * t_cust_consumer表中的主键ID
     */
    @Column(name = "consumer_id")
    private Long consumerId;

    /**
     * 医院id
     */
    @Column(name = "hospital_id")
    private Long hospitalId;

    /**
     * 店家ID
     */
    @Column(name = "shop_id")
    private Long shopId;

    /**
     * 业务员id
     */
    @Column(name = "bussiness_user_id")
    private Long bussinessUserId;

    @Column(name = "attr_url")
    private String attrUrl;

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
     * 备注信息
     */
    private String remark;

    /**
     * 更新人
     */
    @Column(name = "update_id")
    private Long updateId;

    /**
     * 状态：1有效；0无效
     */
    private Integer status;

    /**
     * 审核状态 1未审核 2审核通过  3未通过
     */
    @Column(name = "audit_status")
    private Integer auditStatus;

    /**
     * 不通过理由
     */
    @Column(name = "audit_reason")
    private String auditReason;

    /**
     * 创建者id
     */
    @Column(name = "create_id")
    private Long createId;
}