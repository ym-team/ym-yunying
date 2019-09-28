package com.hmn.ym.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmn.ym.dao.entity.po.CustAppointment;
import com.hmn.ym.dao.mapper.CustAppointmentMapper;
import com.hmn.ym.service.ICustAppointmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
* @description 业务层
* @author  xfz
* @since
*/
@Service
public class CustAppointmentServiceImpl extends BaseServiceImpl<CustAppointment, CustAppointmentMapper> implements ICustAppointmentService {
    @Autowired
    private CustAppointmentMapper custAppointmentMapper;

    @Transactional
    @Override
    public void save(CustAppointment vo) {
        if (vo.getId() != null) {
            CustAppointment custAppointment = new CustAppointment();
            BeanUtils.copyProperties(vo, custAppointment);

            custAppointmentMapper.updateByPrimaryKeySelective(custAppointment);
        } else {

            CustAppointment custAppointment = new CustAppointment();
            BeanUtils.copyProperties(vo, custAppointment);

            custAppointmentMapper.insertSelective(custAppointment);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        custAppointmentMapper.deleteByPrimaryKey(id);
    }
}




