package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.Doctor;
import com.hmn.ym.dao.mapper.DoctorMapper;
import com.hmn.ym.service.ISalesManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesManServiceImpl extends BaseServiceImpl<Doctor, DoctorMapper> implements ISalesManService {
    @Autowired
    private DoctorMapper doctorMapper;

}
