package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.CfgParaDetail;
import com.hmn.ym.dao.mapper.CfgParaDetailMapper;
import com.hmn.ym.service.ICfgParaDetailService;
import com.hmn.ym.utils.CachCfgParaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
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

    @Override
    @PostConstruct
    public void getAllCfgParaToCach() {
        for (CfgParaDetail cfg : selectCfgParaDetailEntityList()) {
            CachCfgParaUtil.putCfgCache(cfg.getParaKey(), cfg.getParaValue());
        }
    }

    private List<CfgParaDetail> selectCfgParaDetailEntityList() {
        return cfgParaDetailMapper.selectAll();
    }
}