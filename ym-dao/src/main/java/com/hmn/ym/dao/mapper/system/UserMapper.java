package com.hmn.ym.dao.mapper.system;

import com.hmn.ym.dao.entities.po.system.User;
import com.hmn.ym.dao.entities.vo.system.UserVo;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {

    UserVo getUserWithRolesPermissions(String userName);
}