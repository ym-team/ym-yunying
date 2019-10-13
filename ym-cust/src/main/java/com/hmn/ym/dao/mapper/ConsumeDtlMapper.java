package com.hmn.ym.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hmn.ym.dao.entity.po.ConsumeDtl;
import tk.mybatis.mapper.common.Mapper;

public interface ConsumeDtlMapper extends Mapper<ConsumeDtl> {

	Double queryMyMoneyByThisMonth(@Param("userId")long userId);

	Double myTeamMoney(@Param("listUserId") List<Long> listUserId2);

	Double queryMyOrderByThisMonth(@Param("userId")long userId);
	
	Double myTeamOrder(@Param("listUserId") List<Long> listUserId2);

	Double myAddShop(@Param("userId")long userId);

	Double myTeamAddShop(@Param("listUserId") List<Long> listUserId2);

	Double myAppointMentCustmer(@Param("userId")long userId);

	Double myTeamAppointMentCustmer(@Param("listUserId") List<Long> listUserId2);

	List<ConsumeDtl> myMonesyList(@Param("userId")long userId);
}