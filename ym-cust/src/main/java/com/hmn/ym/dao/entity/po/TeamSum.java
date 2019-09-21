package com.hmn.ym.dao.entity.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Table(name = "t_team_sum")
public class TeamSum {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 团队id
     */
    @Column(name = "team_id")
    private Long teamId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 团队金额
     */
    @Column(name = "team_sum_fee")
    private BigDecimal teamSumFee;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 当前月份
     */
    @Column(name = "years_month")
    private Integer yearsMonth;
}