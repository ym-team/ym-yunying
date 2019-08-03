package com.hmn.ym.dao.entities.vo.system;

import com.hmn.ym.dao.entities.vo.BaseVo;
import lombok.Data;

/**
 * <p>
 * 菜单-角色对应关系表
 * </p>
 *
 * @author xfz
 * @since 2018-07-11
 */
@Data
public class RoleMenuVo extends BaseVo {
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 菜单id
     */
    private Integer menuId;
    /**
     * 菜单ids
     */
    private String menuIds;

    /**
     * 菜单-按钮ids
     */
    private String permissionIds;
}
