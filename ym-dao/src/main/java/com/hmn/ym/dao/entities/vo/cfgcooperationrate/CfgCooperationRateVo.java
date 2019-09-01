package com.hmn.ym.dao.entities.vo.cfgcooperationrate;

import com.hmn.ym.dao.entities.vo.BaseVo;
import lombok.Data;

@Data
public class CfgCooperationRateVo extends BaseVo {
    /**
     * 合作者用户ID 如医院id 店面id
     */
    private Long amortizationId;

    private Byte status;

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