package com.hmn.ym.manager.service.hospital.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmn.ym.dao.entities.po.Hospital;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.hospital.HospitalVo;
import com.hmn.ym.dao.mapper.HospitalMapper;
import com.hmn.ym.manager.service.BaseServiceImpl;
import com.hmn.ym.manager.service.hospital.IHospitalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class HospitalServiceImpl extends BaseServiceImpl<Hospital, HospitalMapper> implements IHospitalService {
    @Autowired
    private HospitalMapper hospitalMapper;

    @Override
    public DataTablePage<Hospital> page(BaseQueryVo vo) {
        PageHelper.startPage(vo.getStart(), vo.getLength());
        Page<Hospital> page = (Page<Hospital>) hospitalMapper.selectAll();
        return new DataTablePage<Hospital>(vo.getDraw(), (int) page.getTotal(), page.getResult());
    }

    @Transactional
    @Override
    public void save(HospitalVo vo) {
        if (vo.getId() != null) {
            Hospital exit = hospitalMapper.selectByPrimaryKey(vo.getId());
            if (!exit.getName().equals(vo.getName())) {
                this.exit(vo.getName());
            }
            Hospital hospital = new Hospital();
            BeanUtils.copyProperties(vo, hospital);

            hospitalMapper.updateByPrimaryKeySelective(hospital);
        } else {
            this.exit(vo.getName());

            Hospital hospital = new Hospital();
            BeanUtils.copyProperties(vo, hospital);
            hospital.setCreateTime(new Date());

            hospitalMapper.insertSelective(hospital);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        hospitalMapper.deleteByPrimaryKey(id);
    }

    private void exit(String roleName) {
        Example example = new Example(Hospital.class);
        example.createCriteria().andEqualTo("name", roleName);
        Hospital role = hospitalMapper.selectOneByExample(example);
        if (role != null) {
            throw new RuntimeException("该角色已经存在.");
        }
    }
}
