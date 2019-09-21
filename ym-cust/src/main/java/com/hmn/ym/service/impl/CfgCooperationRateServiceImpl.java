package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.CfgCooperationRate;
import com.hmn.ym.dao.mapper.CfgCooperationRateMapper;
import com.hmn.ym.service.ICfgCooperationRateService;
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
public class CfgCooperationRateServiceImpl extends BaseServiceImpl<CfgCooperationRate, CfgCooperationRateMapper> implements ICfgCooperationRateService {
    @Autowired
    private CfgCooperationRateMapper cfgCooperationRateMapper;

    @Transactional
    @Override
    public void save(CfgCooperationRate vo) {
        if (vo.getId() != null) {
            CfgCooperationRate cfgCooperationRate = new CfgCooperationRate();
            BeanUtils.copyProperties(vo, cfgCooperationRate);

            cfgCooperationRateMapper.updateByPrimaryKeySelective(cfgCooperationRate);
        } else {

            CfgCooperationRate cfgCooperationRate = new CfgCooperationRate();
            BeanUtils.copyProperties(vo, cfgCooperationRate);

            cfgCooperationRateMapper.insertSelective(cfgCooperationRate);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        cfgCooperationRateMapper.deleteByPrimaryKey(id);
    }
}




