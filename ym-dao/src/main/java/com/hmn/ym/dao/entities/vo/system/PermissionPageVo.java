package com.hmn.ym.dao.entities.vo.system;

import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import lombok.Data;

@Data
public class PermissionPageVo extends BaseQueryVo {
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
     * 项目ID
     */
    private Integer projectId;
}