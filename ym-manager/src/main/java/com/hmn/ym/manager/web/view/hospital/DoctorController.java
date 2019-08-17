package com.hmn.ym.manager.web.view.hospital;

import com.hmn.ym.manager.service.hospital.IDoctorService;
import com.hmn.ym.manager.service.hospital.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/doctor")
public class DoctorController {
    @Autowired
    private IDoctorService doctorService;
    @Autowired
    private IHospitalService iHospitalService;

    @GetMapping(value = "/list")
    public String list() {
        return "/hospital/doctor-list";
    }

    @GetMapping(value = "/handle")
    public String handle(Model model, Integer doctorId) {
        model.addAttribute("doctor", doctorService.selectByPrimaryKey(doctorId));
        model.addAttribute("hospitals", iHospitalService.selectAll());

        return "/hospital/doctor-handle";
    }
}
