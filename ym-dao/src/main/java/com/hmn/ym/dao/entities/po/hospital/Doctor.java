package com.hmn.ym.dao.entities.po.hospital;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_hospital_doctor")
@Getter
@Setter
public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    private Integer hospitalId;
    /**
     * 创建人Id
     */
    @Column(name = "create_id")
    private Integer createId;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
}