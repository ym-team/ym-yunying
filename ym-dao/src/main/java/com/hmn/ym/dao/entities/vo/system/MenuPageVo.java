package com.hmn.ym.dao.entities.vo.system;

import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import lombok.Data;

/**
 * <p>
 * 系统菜单表
 * </p>
 *
 * @author xfz
 * @since 2018-07-04
 */
@Data
public class MenuPageVo extends BaseQueryVo {
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
}
