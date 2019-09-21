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
public class TeamVo extends BaseVo {


    /**
     * 用户表id
     */
    private Long userId;

    /**
     *
     */
    private Long parentId;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;
}
