package com.hmn.ym.service;

import java.util.List;

import com.hmn.ym.dao.entity.po.ConsumeDtl;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
public interface IConsumeDtlService extends BaseService<ConsumeDtl> {
    /**
     * 保存
     *
     * @param vo
     */
    void save(ConsumeDtl vo);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);
    
    
    public double queryMyMoneyByThisMonth(long userId) ;

	double myTeamMoney(List<Long> listUserId2);

    /**
     * 获取数据
     *
     * @param appointmentId
     */
    ConsumeDtl getByAppointmentId(Long appointmentId);

    
	double queryMyOrderByThisMonth(Long userId);

	double myTeamOrder(List<Long> listUserId);

	double myAddShop(Long userId);

	double myTeamAddShop(List<Long> listUserId2);

	double myAppointMentCustmer(Long userId);

	double myTeamAppointMentCustmer(List<Long> listUserId2);
}




