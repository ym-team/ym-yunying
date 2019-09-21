package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.CfgCooperationRate;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
public interface ICfgCooperationRateService extends BaseService<CfgCooperationRate> {
    /**
     * 保存
     *
     * @param vo
     */
    void save(CfgCooperationRate vo);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);
}




