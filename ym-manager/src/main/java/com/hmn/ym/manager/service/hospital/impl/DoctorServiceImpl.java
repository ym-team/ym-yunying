package com.hmn.ym.manager.service.hospital.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.hmn.ym.dao.entities.po.hospital.Doctor;
import com.hmn.ym.dao.entities.po.hospital.Hospital;
import com.hmn.ym.dao.entities.po.system.Role;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.hospital.DoctorVo;
import com.hmn.ym.dao.mapper.hospital.DoctorMapper;
import com.hmn.ym.manager.service.BaseServiceImpl;
import com.hmn.ym.manager.service.hospital.IDoctorService;
import com.hmn.ym.manager.service.hospital.IHospitalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class DoctorServiceImpl extends BaseServiceImpl<Doctor, DoctorMapper> implements IDoctorService {
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private IHospitalService hospitalService;

    @Override
    public DataTablePage<DoctorVo> page(BaseQueryVo vo) {
        PageHelper.startPage(vo.getStart(), vo.getLength());
        Page<Doctor> page = (Page<Doctor>) doctorMapper.selectAll();
        List<DoctorVo> list = Lists.newArrayList();
        for (Doctor doctor : page.getResult()) {
            DoctorVo dVo = new DoctorVo();
            BeanUtils.copyProperties(doctor, dVo);
            Hospital hospital = hospitalService.selectByPrimaryKey(doctor.getHospitalId());
            if (hospital != null) {
                dVo.setHospitalName(hospital.getName());
            }
            list.add(dVo);
        }
        return new DataTablePage<DoctorVo>(vo.getDraw(), (int) page.getTotal(), list);
    }

    @Transactional
    @Override
    public void save(DoctorVo vo) {
        if (vo.getId() != null) {
            Doctor exit = doctorMapper.selectByPrimaryKey(vo.getId());
            if (!exit.getName().equals(vo.getName())) {
                this.exit(vo.getName());
            }
            Doctor doctor = new Doctor();
            BeanUtils.copyProperties(vo, doctor);

            doctorMapper.updateByPrimaryKeySelective(doctor);
        } else {
            this.exit(vo.getName());

            Doctor doctor = new Doctor();
            BeanUtils.copyProperties(vo, doctor);
            doctor.setCreateTime(new Date());

            doctorMapper.insertSelective(doctor);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        doctorMapper.deleteByPrimaryKey(id);
    }

    private void exit(String roleName) {
        Example example = new Example(Role.class);
        example.createCriteria().andEqualTo("name", roleName);
        Doctor doctor = doctorMapper.selectOneByExample(example);
        if (doctor != null) {
            throw new RuntimeException("该角色已经存在.");
        }
    }
}
