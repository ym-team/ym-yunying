package com.hmn.ym.dao.entity.vo;

import com.hmn.ym.dao.entity.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
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
public class BussinessSumVo extends BaseEntity {
    /**
     * 业务员id
     */
    private Long bussinessUserId;

    /**
     *
     */
    private Long teamId;

    /**
     * 业务员月统计金额
     */
    private BigDecimal totalAmt;

    /**
     * 备注信息
     */
    private String remark;
}
