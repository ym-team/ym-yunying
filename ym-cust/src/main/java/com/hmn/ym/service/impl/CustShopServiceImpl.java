package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.CustShop;
import com.hmn.ym.dao.mapper.CustShopMapper;
import com.hmn.ym.service.ICustShopService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
@Service
public class CustShopServiceImpl extends BaseServiceImpl<CustShop, CustShopMapper> implements ICustShopService {
    @Autowired
    private CustShopMapper custShopMapper;

    @Transactional
    @Override
    public void save(CustShop vo) {
        if (vo.getId() != null) {
            CustShop custShop = new CustShop();
            BeanUtils.copyProperties(vo, custShop);

            custShopMapper.updateByPrimaryKeySelective(custShop);
        } else {

            CustShop custShop = new CustShop();
            BeanUtils.copyProperties(vo, custShop);

            custShopMapper.insertSelective(custShop);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        custShopMapper.deleteByPrimaryKey(id);
    }
}




