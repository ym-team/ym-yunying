package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.Doctor;
import com.hmn.ym.dao.mapper.DoctorMapper;
import com.hmn.ym.service.IDoctorService;
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
public class DoctorServiceImpl extends BaseServiceImpl<Doctor, DoctorMapper> implements IDoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    @Transactional
    @Override
    public void save(Doctor vo) {
        if (vo.getId() != null) {
            Doctor doctor = new Doctor();
            BeanUtils.copyProperties(vo, doctor);

            doctorMapper.updateByPrimaryKeySelective(doctor);
        } else {

            Doctor doctor = new Doctor();
            BeanUtils.copyProperties(vo, doctor);

            doctorMapper.insertSelective(doctor);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        doctorMapper.deleteByPrimaryKey(id);
    }
}




