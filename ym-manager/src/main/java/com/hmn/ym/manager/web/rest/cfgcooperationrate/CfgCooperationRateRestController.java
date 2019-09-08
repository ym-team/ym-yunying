package com.hmn.ym.manager.web.rest.cfgcooperationrate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmn.ym.common.model.BaseResp;
import com.hmn.ym.dao.entities.po.CfgCooperationRate;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.cfgcooperationrate.CfgCooperationRateVo;
import com.hmn.ym.dao.entities.vo.hospital.DoctorVo;
import com.hmn.ym.manager.common.shiro.ShiroUtils;
import com.hmn.ym.manager.service.cfgcooperationrate.ICfgCooperationRateService;
import com.hmn.ym.manager.utils.RespUtil;

@RestController
@RequestMapping(value = "/api/cfgCooperationRate")
public class CfgCooperationRateRestController {
	
    @Autowired
    private ICfgCooperationRateService cfgCooperationRateService;
    
    
    @RequestMapping(value = "/page")
    public DataTablePage<CfgCooperationRateVo> page(Model model, BaseQueryVo vo) {
        return cfgCooperationRateService.page(vo);
    }
    
    
    @PostMapping(value = "/save")
    public ResponseEntity<BaseResp> save(CfgCooperationRate cfgCooperationRate) {
    	Integer userId = ShiroUtils.getUserId();
    	cfgCooperationRate.setCreateId(Long.valueOf(userId));
    	cfgCooperationRate.setCreateTime(new Date());
    	cfgCooperationRate.setUpdateId(Long.valueOf(userId));
    	cfgCooperationRate.setUpdateTime(new Date());
    	cfgCooperationRate.setStatus(1l);
    	
    	cfgCooperationRateService.insert(cfgCooperationRate);

        return RespUtil.success();
    }

    
    
    

}
