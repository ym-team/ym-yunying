package com.hmn.ym.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hmn.ym.dao.entities.CfgParaDetailEntity;
import com.hmn.ym.dao.mapper.CfgParaDetailMapper;
import com.hmn.ym.service.BaseServiceImpl;
import com.hmn.ym.service.ICfgParaDetailService;
import com.hmn.ym.utils.CachCfgParaUtil;

 /**
 * @author oymw
 * @date 
 * @desc 
 */
@Service
@Transactional
public class CfgParaDetailServiceImpl extends BaseServiceImpl<CfgParaDetailEntity, CfgParaDetailMapper> implements ICfgParaDetailService{

	@Autowired
	private CfgParaDetailMapper cfgParaDetailMapper;
 
	
	/**
	 * 服务启动加载
	 */
	@Override
	public void getAllCfgParaToCach(){
		for(CfgParaDetailEntity cfg : selectCfgParaDetailEntityList()){
			CachCfgParaUtil.putCfgCache(cfg.getParaKey(), cfg.getParaValue());
		}
		 
	}
	
	private List<CfgParaDetailEntity> selectCfgParaDetailEntityList(){
		return cfgParaDetailMapper.selectCfgParaDetailEntityList();
	}
	
	
}