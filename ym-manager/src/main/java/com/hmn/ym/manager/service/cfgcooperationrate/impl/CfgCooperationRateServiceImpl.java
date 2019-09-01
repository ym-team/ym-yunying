package com.hmn.ym.manager.service.cfgcooperationrate.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.hmn.ym.dao.entities.po.CfgCooperationRate;
import com.hmn.ym.dao.entities.po.Doctor;
import com.hmn.ym.dao.entities.po.Hospital;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.cfgcooperationrate.CfgCooperationRateVo;
import com.hmn.ym.dao.entities.vo.hospital.DoctorVo;
import com.hmn.ym.dao.mapper.CfgCooperationRateMapper;
import com.hmn.ym.dao.mapper.DoctorMapper;
import com.hmn.ym.manager.service.BaseService;
import com.hmn.ym.manager.service.BaseServiceImpl;
import com.hmn.ym.manager.service.cfgcooperationrate.ICfgCooperationRateService;
import com.hmn.ym.manager.service.hospital.IDoctorService;
@Service
public class CfgCooperationRateServiceImpl extends BaseServiceImpl<CfgCooperationRate, CfgCooperationRateMapper> implements ICfgCooperationRateService{

    @Autowired
    private CfgCooperationRateMapper CfgCooperationRateMapper;
	
	@Override
	public DataTablePage<CfgCooperationRateVo> page(BaseQueryVo vo) {
		 PageHelper.startPage(vo.getStart(), vo.getLength());
	     Page<CfgCooperationRate> page = (Page<CfgCooperationRate>) CfgCooperationRateMapper.selectAll();
	     List<CfgCooperationRateVo> list = Lists.newArrayList();
	     for(CfgCooperationRate cfgCooperationRate : page.getResult()){
	    	 CfgCooperationRateVo dVo = new CfgCooperationRateVo();
	         BeanUtils.copyProperties(cfgCooperationRate, dVo);
	         list.add(dVo);
	     }
	     
	     return new DataTablePage<CfgCooperationRateVo>(vo.getDraw(), (int) page.getTotal(), list);
	}



}
