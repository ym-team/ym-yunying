package com.hmn.ym.service.shop.impl;

import com.google.common.collect.Lists;
import com.hmn.ym.dao.entities.po.Doctor;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.shop.SalesManVo;
import com.hmn.ym.dao.mapper.DoctorMapper;
import com.hmn.ym.service.BaseServiceImpl;
import com.hmn.ym.service.shop.ISalesManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesManServiceImpl extends BaseServiceImpl<Doctor, DoctorMapper> implements ISalesManService {
    @Autowired
    private DoctorMapper doctorMapper;

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
