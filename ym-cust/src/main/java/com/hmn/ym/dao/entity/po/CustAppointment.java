package com.hmn.ym.dao.entity.po;

import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "t_cust_appointment")
public class CustAppointment {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 顾客id
     */
    @Column(name = "consu_id")
    private String consuId;

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
     * 业务员id
     */
    @Column(name = "bussiness_user_id")
    private Long bussinessUserId;

    /**
     * 确定项目
     */
    @Column(name = "consu_confirm_item")
    private String consuConfirmItem;

    /**
     * 预约医院
     */
    @Column(name = "consu_yu_yue_hospital")
    private String consuYuYueHospital;

    /**
     * 预约时间
     */
    @Column(name = "appointment_time")
    private Date appointmentTime;

    /**
     * 接待员
     */
    @Column(name = "jie_dai_yuan")
    private String jieDaiYuan;

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
}