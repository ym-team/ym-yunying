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
public class BussinessSumVo extends BaseVo {


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
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     * 创建者
     */
    private Long createId;

    /**
     *
     */
    private Long updateId;

    /**
     * 备注信息
     */
    private String remark;
}
