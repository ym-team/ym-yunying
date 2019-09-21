package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.BussinessSum;
import com.hmn.ym.dao.mapper.BussinessSumMapper;
import com.hmn.ym.service.IBussinessSumService;
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
public class BussinessSumServiceImpl extends BaseServiceImpl<BussinessSum, BussinessSumMapper> implements IBussinessSumService {
    @Autowired
    private BussinessSumMapper bussinessSumMapper;

    @Transactional
    @Override
    public void save(BussinessSum vo) {
        if (vo.getId() != null) {
            BussinessSum bussinessSum = new BussinessSum();
            BeanUtils.copyProperties(vo, bussinessSum);

            bussinessSumMapper.updateByPrimaryKeySelective(bussinessSum);
        } else {

            BussinessSum bussinessSum = new BussinessSum();
            BeanUtils.copyProperties(vo, bussinessSum);

            bussinessSumMapper.insertSelective(bussinessSum);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        bussinessSumMapper.deleteByPrimaryKey(id);
    }
}




