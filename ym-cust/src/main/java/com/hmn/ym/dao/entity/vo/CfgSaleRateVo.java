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
public class CfgSaleRateVo extends BaseVo {


    /**
     * 月销售总额开始
     */
    private BigDecimal monSaleTotalAmtBegin;

    /**
     * 月销售总额结束
     */
    private BigDecimal monSaleTotalAmtEnd;

    /**
     * 提成比例
     */
    private Double rate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建者
     */
    private Long createId;

    /**
     * 修改者id
     */
    private Long updateId;

    /**
     * 类型 1个人；2团队
     */
    private Long type;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 是否有效 1有效；0无效
     */
    private Integer status;
}
