package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.CustConsumer;
import com.hmn.ym.dao.mapper.CustConsumerMapper;
import com.hmn.ym.service.ICustConsumerService;
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
public class CustConsumerServiceImpl extends BaseServiceImpl<CustConsumer, CustConsumerMapper> implements ICustConsumerService {
    @Autowired
    private CustConsumerMapper custConsumerMapper;

    @Transactional
    @Override
    public void save(CustConsumer vo) {
        if (vo.getId() != null) {
            CustConsumer custConsumer = new CustConsumer();
            BeanUtils.copyProperties(vo, custConsumer);

            custConsumerMapper.updateByPrimaryKeySelective(custConsumer);
        } else {

            CustConsumer custConsumer = new CustConsumer();
            BeanUtils.copyProperties(vo, custConsumer);

            custConsumerMapper.insertSelective(custConsumer);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        custConsumerMapper.deleteByPrimaryKey(id);
    }
}




