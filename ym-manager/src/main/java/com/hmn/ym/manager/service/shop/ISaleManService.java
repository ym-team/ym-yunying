package com.hmn.ym.manager.service.shop;

import com.hmn.ym.dao.entities.po.Doctor;
import com.hmn.ym.dao.entities.po.SaleMan;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.hospital.DoctorVo;
import com.hmn.ym.dao.entities.vo.shop.SalesManVo;
import com.hmn.ym.dao.entities.vo.shop.ShopVo;
import com.hmn.ym.manager.service.BaseService;

public interface ISaleManService extends BaseService<SaleMan> {

    /**
     * 获取店铺分页
     *
     * @param vo
     * @return
     */
    DataTablePage<SalesManVo> page(BaseQueryVo vo);
}
