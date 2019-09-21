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
public class CfgCooperationRateVo extends BaseVo {


    /**
     * 合作者用户ID 如医院id 店面id
     */
    private Long amortizationId;

    /**
     *
     */
    private Long status;

    /**
     * 医院提成比例
     */
    private Double rate;

    /**
     * 提成类型 1医院 2店面
     */
    private Integer type;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 更新者
     */
    private Long updateId;

    /**
     * 创建者
     */
    private Long createId;
}
