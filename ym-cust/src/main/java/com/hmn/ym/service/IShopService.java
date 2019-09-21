package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.Doctor;
import com.hmn.ym.dao.entity.vo.BaseQueryVo;
import com.hmn.ym.dao.entity.vo.DataTablePage;
import com.hmn.ym.dao.entity.vo.ShopVo;

public interface IShopService extends BaseService<Doctor> {

    /**
     * 获取店铺分页
     *
     * @param vo
     * @return
     */
    DataTablePage<ShopVo> page(BaseQueryVo vo);
}
