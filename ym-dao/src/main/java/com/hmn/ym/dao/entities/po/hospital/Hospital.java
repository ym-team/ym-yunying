package com.hmn.ym.dao.entities.po.hospital;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_hospital")
@Getter
@Setter
public class Hospital implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 医院名称
     */
    private String name;
    /**
     * 医院地址
     */
    private String address;
    /**
     * logo
     */
    private String logo;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 医院介绍
     */
    private String remark;
    /**
     * 联系人
     */
    private String contactor;
    /**
     * 创建人
     */
    @Column(name = "create_id")
    private Integer createId;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
}