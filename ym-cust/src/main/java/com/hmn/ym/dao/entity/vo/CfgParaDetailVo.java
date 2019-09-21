package com.hmn.ym.dao.entity.vo;

import com.hmn.ym.dao.entity.BaseEntity;
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
public class CfgParaDetailVo extends BaseEntity {
    /**
     * 主键ID
     */
    private String pkId;

    /**
     * 参数键
     */
    private String paraKey;

    /**
     * 参数值
     */
    private String paraValue;

    /**
     * 参数代码
     */
    private String paraCode;

    /**
     * 参数名称
     */
    private String paraName;

    /**
     * 参数描述
     */
    private String paraDesc;

    /**
     * 状态 0无效;1有效
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date upTime;

    /**
     * 备注
     */
    private String remarks;
}
