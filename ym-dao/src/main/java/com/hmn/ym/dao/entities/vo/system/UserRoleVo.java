package com.hmn.ym.dao.entities.vo.system;

import com.hmn.ym.dao.entities.vo.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xfz
 * @since 2018-05-28
 */
@Getter
@Setter
public class UserRoleVo extends BaseVo {
    /**
     * 用户ID(t_sys_user.id)
     */
    private Integer userId;
    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色ids
     */
    private String roleIds;
}
