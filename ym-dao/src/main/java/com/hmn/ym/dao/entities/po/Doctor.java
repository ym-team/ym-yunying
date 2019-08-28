package com.hmn.ym.dao.entities.po;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Table(name = "t_hospital_doctor")
@Getter@Setter
public class Doctor implements Serializable {
    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 医生名称
     */
    private String name;

    /**
     * 职位
     */
    private String position;

    /**
     * 头像
     */
    @Column(name = "head_img")
    private String headImg;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 医院Id
     */
    @Column(name = "hospital_id")
    private Long hospitalId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人Id
     */
    @Column(name = "create_id")
    private Long createId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者Id
     */
    @Column(name = "update_id")
    private Long updateId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}