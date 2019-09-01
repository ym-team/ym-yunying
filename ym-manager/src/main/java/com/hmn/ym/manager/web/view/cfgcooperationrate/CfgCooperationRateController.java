package com.hmn.ym.manager.web.view.cfgcooperationrate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/cfgCooperationRate")
public class CfgCooperationRateController {
	
	
    @GetMapping(value = "/list")
    public String list() {
        return "/cfgCooperationRate/cfgCooperationRate-list";
    }
    
    
    @GetMapping(value = "/handle")
    public String handle(Model model, Integer doctorId) {
      //  model.addAttribute("doctor", doctorService.selectByPrimaryKey(doctorId));
    //    model.addAttribute("hospitals", iHospitalService.selectAll());

        return "/cfgCooperationRate/cfgCooperationRate-handle";
    }

}
