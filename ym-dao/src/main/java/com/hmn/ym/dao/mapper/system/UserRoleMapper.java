package com.hmn.ym.dao.mapper.system;

import com.hmn.ym.dao.entities.po.system.UserRole;
import tk.mybatis.mapper.common.Mapper;

public interface UserRoleMapper extends Mapper<UserRole> {

    void deleteByUserId(Integer userId);

    void deleteByRoleId(Integer roleId);
}