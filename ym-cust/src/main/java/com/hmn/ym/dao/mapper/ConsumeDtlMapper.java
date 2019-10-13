package com.hmn.ym.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hmn.ym.dao.entity.po.ConsumeDtl;
import tk.mybatis.mapper.common.Mapper;

public interface ConsumeDtlMapper extends Mapper<ConsumeDtl> {

	double queryMyMoneyByThisMonth(@Param("userId")long userId);

	double myTeamMoney(@Param("listUserId") List<Long> listUserId2);

	double queryMyOrderByThisMonth(@Param("userId")long userId);
	
	double myTeamOrder(@Param("listUserId") List<Long> listUserId2);

	double myAddShop(@Param("userId")long userId);

	double myTeamAddShop(@Param("listUserId") List<Long> listUserId2);

	double myAppointMentCustmer(@Param("userId")long userId);

	double myTeamAppointMentCustmer(@Param("listUserId") List<Long> listUserId2);
}