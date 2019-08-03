package com.hmn.ym.dao.mapper.system;

import com.hmn.ym.dao.entities.po.system.RoleMenu;
import tk.mybatis.mapper.common.Mapper;

public interface RoleMenuMapper extends Mapper<RoleMenu> {

    int deleteByRoleId(Integer roleId);

}