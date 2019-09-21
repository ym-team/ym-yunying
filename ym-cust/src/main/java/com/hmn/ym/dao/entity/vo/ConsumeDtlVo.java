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
public class ConsumeDtlVo extends BaseVo {


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
     *
     */
    private String attrUrl;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 更新人
     */
    private Long updateId;

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

    /**
     * 创建者id
     */
    private Long createId;
}
