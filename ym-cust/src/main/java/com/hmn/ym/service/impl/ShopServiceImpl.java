package com.hmn.ym.service.impl;

import com.google.common.collect.Lists;
import com.hmn.ym.dao.entity.po.Doctor;
import com.hmn.ym.dao.entity.vo.BaseQueryVo;
import com.hmn.ym.dao.entity.vo.DataTablePage;
import com.hmn.ym.dao.entity.vo.ShopVo;
import com.hmn.ym.dao.mapper.DoctorMapper;
import com.hmn.ym.service.IShopService;
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
