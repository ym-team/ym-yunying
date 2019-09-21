package com.hmn.ym.dao.entity.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "t_saleman")
public class SaleMan {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户Id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 业务员真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 身份证号
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 认证状态(1：认证通过  2：未认证  3：认证不通过
     */
    @Column(name = "audit_status")
    private Integer auditStatus;

    /**
     * 身份证手持
     */
    @Column(name = "sfz_sc")
    private String sfzSc;

    /**
     * 身份证正面
     */
    @Column(name = "sfz_zm")
    private String sfzZm;

    /**
     * 身份证反面
     */
    @Column(name = "sfz_fm")
    private String sfzFm;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建者Id
     */
    @Column(name = "update_id")
    private Long updateId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 个人提成比例分配
     */
    private Double rate;
}