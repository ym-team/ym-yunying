package com.hmn.ym.dao.entity.vo;

import com.hmn.ym.dao.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author xfz
 * @since 2018-05-28
 */
@Data
public class TeamVo extends BaseEntity {
    /**
     * 用户表id
     */
    private Long userId;

    /**
     *
     */
    private Long parentId;

    /**
     * 备注
     */
    private String remark;
}
