package com.hmn.ym.dao.entity.vo;

import com.hmn.ym.dao.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author xfz
 * @since 2018-05-28
 */
@Data
public class HospitalVo extends BaseEntity {
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
