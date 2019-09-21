package com.hmn.ym.dao.entity.vo;

import com.hmn.ym.dao.entity.BaseEntity;
import lombok.Data;

@Data
public class CfgCooperationRateVo extends BaseEntity {
    /**
     * 合作者用户ID 如医院id 店面id
     */
    private Long amortizationId;

    private Long status;

    /**
     * 医院提成比例
     */
    private Double rate;

    /**
     * 提成类型 1医院 2店面
     */
    private Byte type;

    /**
     * 备注信息
     */
    private String remark;
}