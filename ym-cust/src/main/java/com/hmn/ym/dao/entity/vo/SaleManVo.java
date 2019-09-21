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
public class SaleManVo extends BaseEntity {
    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 业务员真实姓名
     */
    private String realName;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 认证状态(1：认证通过  2：未认证  3：认证不通过
     */
    private Integer auditStatus;

    /**
     * 身份证手持
     */
    private String sfzSc;

    /**
     * 身份证正面
     */
    private String sfzZm;

    /**
     * 身份证反面
     */
    private String sfzFm;

    /**
     * 备注
     */
    private String remark;

    /**
     * 个人提成比例分配
     */
    private Double rate;
}
