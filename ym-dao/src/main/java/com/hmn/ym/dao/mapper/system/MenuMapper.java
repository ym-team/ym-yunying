package com.hmn.ym.dao.mapper.system;

import com.hmn.ym.dao.entities.po.system.Menu;
import com.hmn.ym.dao.entities.vo.system.MenuVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {

    List<MenuVo> selectByUserId(@Param("userId") Integer userId, @Param("projectId") Integer projectId);
}