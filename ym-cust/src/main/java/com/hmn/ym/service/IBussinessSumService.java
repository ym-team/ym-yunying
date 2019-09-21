package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.BussinessSum;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
public interface IBussinessSumService extends BaseService<BussinessSum> {
    /**
     * 保存
     *
     * @param vo
     */
    void save(BussinessSum vo);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);
}




