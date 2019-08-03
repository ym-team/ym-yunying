package com.hmn.ym.dao.entities.vo.hospital;

import com.hmn.ym.dao.entities.vo.BaseVo;
import lombok.Data;

@Data
public class HospitalVo extends BaseVo {
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
}
