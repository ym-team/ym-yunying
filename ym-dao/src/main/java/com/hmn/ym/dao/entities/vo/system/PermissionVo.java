package com.hmn.ym.dao.entities.vo.system;

import com.hmn.ym.dao.entities.vo.BaseVo;
import lombok.Data;

@Data
public class PermissionVo extends BaseVo {
    /**
     * 按钮名称
     */
    private String name;

    /**
     * 按钮编码
     */
    private String code;

    /**
     * 按钮url
     */
    private String url;

    /**
     * 菜单ID
     */
    private Integer menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 是否有按钮的权限
     */
    private boolean hasPermission;

}