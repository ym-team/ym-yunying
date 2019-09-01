package com.hmn.ym.dao.entities.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Table(name = "t_team_sum")
@Getter@Setter
public class TeamSum implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_id")
    private Long teamId;

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

    private static final long serialVersionUID = 1L;
}