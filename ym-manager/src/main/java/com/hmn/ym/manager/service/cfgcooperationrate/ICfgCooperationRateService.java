package com.hmn.ym.manager.service.cfgcooperationrate;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.hmn.ym.dao.entities.po.CfgCooperationRate;
import com.hmn.ym.dao.entities.po.Doctor;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.cfgcooperationrate.CfgCooperationRateVo;
import com.hmn.ym.dao.entities.vo.hospital.DoctorVo;
import com.hmn.ym.manager.service.BaseService;

public interface ICfgCooperationRateService extends BaseService<CfgCooperationRate>{
	
	
    DataTablePage<CfgCooperationRateVo> page(BaseQueryVo vo);



}
