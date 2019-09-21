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
public class DoctorVo extends BaseVo {


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
    private Long hospitalId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人Id
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者Id
     */
    private Long updateId;

    /**
     * 更新时间
     */
    private Date updateTime;
}
