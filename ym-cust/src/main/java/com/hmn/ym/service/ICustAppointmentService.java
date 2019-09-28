package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.CustAppointment;

/**
* @description 业务层
* @author  xfz
* @since
*/
public interface ICustAppointmentService extends BaseService<CustAppointment> {
    /**
    * 保存
    *
    * @param vo
    */
    void save(CustAppointment vo);

    /**
    * 删除
    *
    * @param id
    */
    void delete(Integer id);
}




