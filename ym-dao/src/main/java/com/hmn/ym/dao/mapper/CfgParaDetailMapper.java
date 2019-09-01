package com.hmn.ym.dao.mapper;

import com.hmn.ym.dao.entities.po.CfgParaDetail;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CfgParaDetailMapper extends Mapper<CfgParaDetail> {

    List<CfgParaDetail> selectCfgParaDetailEntityList();
}