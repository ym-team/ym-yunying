package com.hmn.ym.service;

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

    /**
     * 获取数据
     *
     * @param appointmentId
     */
    ConsumeDtl getByAppointmentId(Long appointmentId);
}




