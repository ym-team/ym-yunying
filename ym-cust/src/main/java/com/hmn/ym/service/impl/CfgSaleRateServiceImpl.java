package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.CfgSaleRate;
import com.hmn.ym.dao.mapper.CfgSaleRateMapper;
import com.hmn.ym.service.ICfgSaleRateService;
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
public class CfgSaleRateServiceImpl extends BaseServiceImpl<CfgSaleRate, CfgSaleRateMapper> implements ICfgSaleRateService {
    @Autowired
    private CfgSaleRateMapper cfgSaleRateMapper;

    @Transactional
    @Override
    public void save(CfgSaleRate vo) {
        if (vo.getId() != null) {
            CfgSaleRate cfgSaleRate = new CfgSaleRate();
            BeanUtils.copyProperties(vo, cfgSaleRate);

            cfgSaleRateMapper.updateByPrimaryKeySelective(cfgSaleRate);
        } else {

            CfgSaleRate cfgSaleRate = new CfgSaleRate();
            BeanUtils.copyProperties(vo, cfgSaleRate);

            cfgSaleRateMapper.insertSelective(cfgSaleRate);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        cfgSaleRateMapper.deleteByPrimaryKey(id);
    }
}




