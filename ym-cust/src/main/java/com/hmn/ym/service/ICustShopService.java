package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.CustShop;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
public interface ICustShopService extends BaseService<CustShop> {
    /**
     * 保存
     *
     * @param vo
     */
    void save(CustShop vo);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);
}




