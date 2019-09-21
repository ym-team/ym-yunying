package com.hmn.ym.dao.entity.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Table(name = "t_cfg_sale_rate")
public class CfgSaleRate {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 月销售总额开始
     */
    @Column(name = "mon_sale_total_amt_begin")
    private BigDecimal monSaleTotalAmtBegin;

    /**
     * 月销售总额结束
     */
    @Column(name = "mon_sale_total_amt_end")
    private BigDecimal monSaleTotalAmtEnd;

    /**
     * 提成比例
     */
    private Double rate;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建者
     */
    @Column(name = "create_id")
    private Long createId;

    /**
     * 修改者id
     */
    @Column(name = "update_id")
    private Long updateId;

    /**
     * 类型 1个人；2团队
     */
    private Long type;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 是否有效 1有效；0无效
     */
    private Integer status;
}