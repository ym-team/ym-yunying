package com.hmn.ym.manager.service.shop.impl;

import com.google.common.collect.Lists;
import com.hmn.ym.dao.entities.po.Doctor;
import com.hmn.ym.dao.entities.po.SaleMan;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.shop.SalesManVo;
import com.hmn.ym.dao.mapper.DoctorMapper;
import com.hmn.ym.dao.mapper.SaleManMapper;
import com.hmn.ym.manager.service.BaseServiceImpl;
import com.hmn.ym.manager.service.hospital.IHospitalService;
import com.hmn.ym.manager.service.shop.ISaleManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleManServiceImpl extends BaseServiceImpl<SaleMan, SaleManMapper> implements ISaleManService {
    @Autowired
    private SaleManMapper saleManMapper;

    @Override
    public DataTablePage<SalesManVo> page(BaseQueryVo vo) {
        List<SalesManVo> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            SalesManVo dVo = new SalesManVo();
            dVo.setId(i);
            dVo.setName("江西美容店");
            dVo.setAddress("江西省刘阳街道330号");
            dVo.setPhone("13800138000");
            dVo.setJob("销售");
            list.add(dVo);
        }
        return new DataTablePage<SalesManVo>(vo.getDraw(), 10, list);
    }
}
