package com.hmn.ym.dao.entities.po;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Table(name = "t_cust_consumer")
@Getter@Setter
public class CustConsumer implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 顾客姓名
     */
    @Column(name = "consu_name")
    private String consuName;

    /**
     * 电话
     */
    @Column(name = "consu_phone")
    private String consuPhone;

    /**
     * 店家id
     */
    @Column(name = "shop_id")
    private Long shopId;

    /**
     * 客户年龄
     */
    @Column(name = "consu_age")
    private Integer consuAge;

    /**
     * 确定项目
     */
    @Column(name = "consu_confirm_item")
    private String consuConfirmItem;

    /**
     * 意向项目
     */
    @Column(name = "consu_wantto_item")
    private String consuWanttoItem;

    /**
     * 享受政策
     */
    @Column(name = "enjoy_policy")
    private String enjoyPolicy;

    /**
     * 服务顾问
     */
    @Column(name = "service_consult")
    private String serviceConsult;

    /**
     * 顾客分析
     */
    @Column(name = "consu_anaylise")
    private String consuAnaylise;

    /**
     * 顾客工作
     */
    @Column(name = "consu_work")
    private String consuWork;

    /**
     * 顾客性格
     */
    @Column(name = "consu_character")
    private String consuCharacter;

    /**
     * 顾客年收入
     */
    @Column(name = "consu_income")
    private String consuIncome;

    /**
     * 顾客消费价值观
     */
    @Column(name = "consu_value")
    private String consuValue;

    /**
     * 铺垫次数
     */
    @Column(name = "consu_pre_count")
    private String consuPreCount;

    /**
     * 最大的抗拒点
     */
    @Column(name = "consu_max_reject")
    private String consuMaxReject;

    /**
     * 业务员id
     */
    @Column(name = "bussiness_user_id")
    private Long bussinessUserId;

    /**
     * 1 正常  2 不正常
     */
    @Column(name = "consu_status")
    private Integer consuStatus;

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

    private static final long serialVersionUID = 1L;
}