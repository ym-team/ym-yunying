package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.Hospital;
import com.hmn.ym.dao.mapper.HospitalMapper;
import com.hmn.ym.service.IHospitalService;
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
public class HospitalServiceImpl extends BaseServiceImpl<Hospital, HospitalMapper> implements IHospitalService {
    @Autowired
    private HospitalMapper hospitalMapper;

    @Transactional
    @Override
    public void save(Hospital vo) {
        if (vo.getId() != null) {
            Hospital hospital = new Hospital();
            BeanUtils.copyProperties(vo, hospital);

            hospitalMapper.updateByPrimaryKeySelective(hospital);
        } else {

            Hospital hospital = new Hospital();
            BeanUtils.copyProperties(vo, hospital);

            hospitalMapper.insertSelective(hospital);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        hospitalMapper.deleteByPrimaryKey(id);
    }
}




