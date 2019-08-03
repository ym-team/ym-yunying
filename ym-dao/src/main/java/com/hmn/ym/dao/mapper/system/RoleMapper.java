package com.hmn.ym.dao.mapper.system;

import com.hmn.ym.dao.entities.po.system.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {

    List<Role> selectByUserId(Integer userId);

}