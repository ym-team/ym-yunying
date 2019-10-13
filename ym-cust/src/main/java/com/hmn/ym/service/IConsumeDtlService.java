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
    
    
    public Double queryMyMoneyByThisMonth(long userId) ;

    Double myTeamMoney(List<Long> listUserId2);

    /**
     * 获取数据
     *
     * @param appointmentId
     */
    ConsumeDtl getByAppointmentId(Long appointmentId);

    
    Double queryMyOrderByThisMonth(Long userId);

    Double myTeamOrder(List<Long> listUserId);

    Double myAddShop(Long userId);

    Double myTeamAddShop(List<Long> listUserId2);

    Double myAppointMentCustmer(Long userId);

    Double myTeamAppointMentCustmer(List<Long> listUserId2);

	List<ConsumeDtl> myMonesyList(Long userId);
}




