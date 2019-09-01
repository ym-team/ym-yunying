package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entities.po.CfgParaDetail;
import com.hmn.ym.dao.mapper.CfgParaDetailMapper;
import com.hmn.ym.service.BaseServiceImpl;
import com.hmn.ym.service.ICfgParaDetailService;
import com.hmn.ym.utils.CachCfgParaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author oymw
 * @date
 * @desc
 */
@Service
@Transactional
public class CfgParaDetailServiceImpl extends BaseServiceImpl<CfgParaDetail, CfgParaDetailMapper> implements ICfgParaDetailService {

    @Autowired
    private CfgParaDetailMapper cfgParaDetailMapper;


    /**
     * 服务启动加载
     */
    @Override
    public void getAllCfgParaToCach() {
        for (CfgParaDetail cfg : selectCfgParaDetailEntityList()) {
            CachCfgParaUtil.putCfgCache(cfg.getParaKey(), cfg.getParaValue());
        }

    }

    private List<CfgParaDetail> selectCfgParaDetailEntityList() {
        return cfgParaDetailMapper.selectCfgParaDetailEntityList();
    }
}