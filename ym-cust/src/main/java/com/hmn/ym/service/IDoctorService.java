package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.Doctor;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
public interface IDoctorService extends BaseService<Doctor> {
    /**
     * 保存
     *
     * @param vo
     */
    void save(Doctor vo);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);
}




