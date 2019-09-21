package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.Hospital;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
public interface IHospitalService extends BaseService<Hospital> {
    /**
     * 保存
     *
     * @param vo
     */
    void save(Hospital vo);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);
}




