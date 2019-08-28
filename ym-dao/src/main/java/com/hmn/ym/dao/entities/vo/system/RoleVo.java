package com.hmn.ym.dao.entities.vo.system;

import com.hmn.ym.dao.entities.vo.BaseVo;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xfz
 * @since 2018-05-28
 */
@Data
public class RoleVo extends BaseVo {
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色描述
     */
    private String description;
}
