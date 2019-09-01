package com.hmn.ym.dao.entities.vo.cfgcooperationrate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Table(name = "t_cfg_cooperation_rate")
@Getter@Setter
public class CfgCooperationRateVo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 合作者用户ID 如医院id 店面id
     */
    @Column(name = "amortization_id")
    private Long amortizationId;

    private Long status;

    /**
     * 医院提成比例
     */
    private Double rate;

    /**
     * 提成类型 1医院 2店面
     */
    private Byte type;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 更新者
     */
    @Column(name = "update_id")
    private Long updateId;

    /**
     * 创建者
     */
    @Column(name = "create_id")
    private Long createId;

    private static final long serialVersionUID = 1L;
}