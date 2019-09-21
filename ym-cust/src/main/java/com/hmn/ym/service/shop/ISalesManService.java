package com.hmn.ym.service.shop;


import com.hmn.ym.dao.entity.po.Doctor;
import com.hmn.ym.dao.entity.vo.BaseQueryVo;
import com.hmn.ym.dao.entity.vo.DataTablePage;
import com.hmn.ym.dao.entity.vo.shop.SalesManVo;
import com.hmn.ym.service.BaseService;

public interface ISalesManService extends BaseService<Doctor> {

    /**
     * 获取店铺分页
     *
     * @param vo
     * @return
     */
    DataTablePage<SalesManVo> page(BaseQueryVo vo);
}
