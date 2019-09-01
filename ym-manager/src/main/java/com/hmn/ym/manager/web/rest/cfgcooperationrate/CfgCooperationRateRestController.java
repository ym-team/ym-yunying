package com.hmn.ym.manager.web.rest.cfgcooperationrate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.cfgcooperationrate.CfgCooperationRateVo;
import com.hmn.ym.dao.entities.vo.hospital.DoctorVo;
import com.hmn.ym.manager.service.cfgcooperationrate.ICfgCooperationRateService;

@RestController
@RequestMapping(value = "/api/cfgCooperationRate")
public class CfgCooperationRateRestController {
	
    @Autowired
    private ICfgCooperationRateService cfgCooperationRateService;
    
    
    @RequestMapping(value = "/page")
    public DataTablePage<CfgCooperationRateVo> page(Model model, BaseQueryVo vo) {
        return cfgCooperationRateService.page(vo);
    }

    
    
    

}
