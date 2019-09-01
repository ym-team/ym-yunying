package com.hmn.ym.dao.mapper;

import java.util.List;

import com.hmn.ym.dao.entities.CfgParaDetailEntity;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author oymw
 * @date [Thu Mar 07 10:38:50 CST 2019]
 * @desc 本类为cfg_para_detail的Dao接口
 */
 
public interface CfgParaDetailMapper  extends Mapper<CfgParaDetailEntity>{
	 
	 /**
	  * 服务启动时查询
	  */
	 public List<CfgParaDetailEntity> selectCfgParaDetailEntityList();
	 
}