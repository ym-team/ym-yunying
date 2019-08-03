package com.hmn.ym.dao.entities.vo.system;

import com.hmn.ym.dao.entities.vo.BaseVo;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 系统菜单表
 * </p>
 *
 * @author xfz
 * @since 2018-05-28
 */
@Data
public class MenuVo extends BaseVo {
    /**
     * 菜单编码
     */
    private String code;
    /**
     * 菜单名
     */
    private String name;
    /**
     * 菜单URL
     */
    private String action;
    /**
     * 父菜单id
     */
    private Integer parentId;
    /**
     * 0:无效、1有效
     */
    private Integer status;
    /**
     * 菜单深度
     */
    private Integer level;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 父菜单名称
     */
    private String parentName;
    /**
     * 子菜单
     */
    private List<MenuVo> childMenus;
    /**
     * 项目ID
     */
    private Integer projectId;
}
