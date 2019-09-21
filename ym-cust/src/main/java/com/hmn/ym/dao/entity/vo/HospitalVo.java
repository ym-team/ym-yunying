package com.hmn.ym.dao.entity.vo;

import com.see.dao.entity.vo.BaseVo;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author xfz
 * @since 2018-05-28
 */
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

    /**
     * 更新者id
     */
    private Long updateId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建者Id
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;
}
