package com.hmn.ym.dao.entity.vo;

import com.hmn.ym.dao.entity.BaseEntity;
import lombok.Data;

@Data
public class DoctorVo extends BaseEntity {
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
    private String headImg;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 医院Id
     */
    private Integer hospitalId;

    /**
     * 医院名称
     */
    private String hospitalName;
}