package com.hmn.ym.manager.web.view.hospital;

import com.hmn.ym.manager.service.hospital.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/hospital")
public class HospitalController {
    @Autowired
    private IHospitalService hospitalService;

    @GetMapping(value = "/list")
    public String list() {
        return "/hospital/hospital-list";
    }

    @GetMapping(value = "/handle")
    public String handle(Model model, Integer hospitalId) {
        model.addAttribute("hospital", hospitalService.selectByPrimaryKey(hospitalId));

        return "/hospital/hospital-handle";
    }
}
