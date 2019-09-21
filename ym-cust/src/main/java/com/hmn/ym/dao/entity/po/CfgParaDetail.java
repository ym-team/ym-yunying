package com.hmn.ym.dao.entity.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Table(name = "cfg_para_detail")
public class CfgParaDetail {
    /**
     * 主键ID
     */
    @Column(name = "PK_ID")
    private String pkId;

    /**
     * 参数键
     */
    @Column(name = "PARA_KEY")
    private String paraKey;

    /**
     * 参数值
     */
    @Column(name = "PARA_VALUE")
    private String paraValue;

    /**
     * 参数代码
     */
    @Column(name = "PARA_CODE")
    private String paraCode;

    /**
     * 参数名称
     */
    @Column(name = "PARA_NAME")
    private String paraName;

    /**
     * 参数描述
     */
    @Column(name = "PARA_DESC")
    private String paraDesc;

    /**
     * 状态 0无效;1有效
     */
    @Column(name = "STATE")
    private Integer state;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "UP_TIME")
    private Date upTime;

    /**
     * 备注
     */
    @Column(name = "REMARKS")
    private String remarks;
}