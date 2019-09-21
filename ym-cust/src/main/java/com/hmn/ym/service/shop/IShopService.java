package com.hmn.ym.service.shop;

import com.hmn.ym.dao.entity.po.Doctor;
import com.hmn.ym.dao.entity.vo.BaseQueryVo;
import com.hmn.ym.dao.entity.vo.DataTablePage;
import com.hmn.ym.dao.entity.vo.shop.ShopVo;
import com.hmn.ym.service.BaseService;

public interface IShopService extends BaseService<Doctor> {

    /**
     * 获取店铺分页
     *
     * @param vo
     * @return
     */
    DataTablePage<ShopVo> page(BaseQueryVo vo);
}
