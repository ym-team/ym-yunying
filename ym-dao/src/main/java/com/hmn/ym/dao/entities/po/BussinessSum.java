package com.hmn.ym.dao.entities.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Table(name = "t_bussiness_sum")
@Getter@Setter
public class BussinessSum implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 业务员id
     */
    @Column(name = "bussiness_user_id")
    private Long bussinessUserId;

    @Column(name = "team_id")
    private Long teamId;

    /**
     * 业务员月统计金额
     */
    @Column(name = "total_amt")
    private BigDecimal totalAmt;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建者
     */
    @Column(name = "create_id")
    private Long createId;

    @Column(name = "update_id")
    private Long updateId;

    /**
     * 备注信息
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}