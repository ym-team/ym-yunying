package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.ConsumeDtl;
import com.hmn.ym.dao.mapper.ConsumeDtlMapper;
import com.hmn.ym.service.IConsumeDtlService;
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
public class ConsumeDtlServiceImpl extends BaseServiceImpl<ConsumeDtl, ConsumeDtlMapper> implements IConsumeDtlService {
    @Autowired
    private ConsumeDtlMapper consumeDtlMapper;

    @Transactional
    @Override
    public void save(ConsumeDtl vo) {
        if (vo.getId() != null) {
            ConsumeDtl consumeDtl = new ConsumeDtl();
            BeanUtils.copyProperties(vo, consumeDtl);

            consumeDtlMapper.updateByPrimaryKeySelective(consumeDtl);
        } else {

            ConsumeDtl consumeDtl = new ConsumeDtl();
            BeanUtils.copyProperties(vo, consumeDtl);

            consumeDtlMapper.insertSelective(consumeDtl);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        consumeDtlMapper.deleteByPrimaryKey(id);
    }
}




