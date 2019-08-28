package com.hmn.ym.service.shop.impl;

import com.google.common.collect.Lists;
import com.hmn.ym.dao.entities.po.Doctor;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.shop.ShopVo;
import com.hmn.ym.dao.mapper.DoctorMapper;
import com.hmn.ym.service.BaseServiceImpl;
import com.hmn.ym.service.shop.IShopService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl extends BaseServiceImpl<Doctor, DoctorMapper> implements IShopService {

    @Override
    public DataTablePage<ShopVo> page(BaseQueryVo vo) {
        List<ShopVo> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            ShopVo dVo = new ShopVo();
            dVo.setId(i);
            dVo.setName("江西美容店");
            dVo.setAddress("江西省刘阳街道330号");
            dVo.setPhone("13800138000");
            dVo.setRemark("整容第一家");
            list.add(dVo);
        }
        return new DataTablePage<ShopVo>(vo.getDraw(), 10, list);
    }
}
