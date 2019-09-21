package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.CfgSaleRate;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
public interface ICfgSaleRateService extends BaseService<CfgSaleRate> {
    /**
     * 保存
     *
     * @param vo
     */
    void save(CfgSaleRate vo);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);
}




