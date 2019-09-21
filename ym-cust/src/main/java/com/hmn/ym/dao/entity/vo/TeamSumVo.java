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
public class TeamSumVo extends BaseVo {


    /**
     * 团队id
     */
    private Long teamId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 团队金额
     */
    private BigDecimal teamSumFee;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 当前月份
     */
    private Integer yearsMonth;
}
