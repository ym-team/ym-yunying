package com.hmn.ym.dao.entity.vo;

import com.hmn.ym.dao.entity.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ConsumeDtlVo extends BaseEntity {

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 总费用
     */
    private BigDecimal sumFee;

    /**
     * 材料费
     */
    private BigDecimal materialsFee;

    /**
     * 预约Id 表t_cust_appointment-id
     */
    private Long appointmentId;

    /**
     * t_cust_consumer表中的主键ID
     */
    private Long consumerId;

    /**
     * 医院id
     */
    private Long hospitalId;

    /**
     * 店家ID
     */
    private Long shopId;

    /**
     * 业务员id
     */
    private Long bussinessUserId;

    /**
     * 费用凭证图片附件地址，多张用逗号隔开
     */
    private String attrUrl;

    /**
     * 备注信息
     */
    private String remark;


    /**
     * 状态：1有效；0无效
     */
    private Integer status;

    /**
     * 审核状态 1未审核 2审核通过  3未通过
     */
    private Integer auditStatus;

    /**
     * 不通过理由
     */
    private String auditReason;
}
