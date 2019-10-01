package com.hmn.ym.controller;

import com.hmn.ym.common.model.BaseResp;
import com.hmn.ym.dao.entity.po.ConsumeDtl;
import com.hmn.ym.dao.entity.vo.ConsumeDtlVo;
import com.hmn.ym.service.IConsumeDtlService;
import com.hmn.ym.service.ICustAppointmentService;
import com.hmn.ym.service.ICustConsumerService;
import com.hmn.ym.service.IHospitalService;
import com.hmn.ym.utils.RespUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/consumeDtl/")
public class ConsumeDtlController extends BaseController {
    @Autowired
    private IConsumeDtlService consumeDtlService;
    @Autowired
    private IHospitalService hospitalService;
    @Autowired
    private ICustAppointmentService custAppointmentService;
    @Autowired
    private ICustConsumerService custConsumerService;

    @GetMapping("detail.do")
    public String detail(HttpServletRequest request, HttpServletResponse response, Model model) {
        String id = request.getParameter("id");
        ConsumeDtl dtl = consumeDtlService.getByAppointmentId(Long.parseLong(id));
        model.addAttribute("dtl", dtl);

        return "/consumedtl/detail";
    }

    @PostMapping("save.do")
    public ResponseEntity<BaseResp> save(ConsumeDtlVo vo, HttpServletRequest request) {
        ConsumeDtl dtl = new ConsumeDtl();
        BeanUtils.copyProperties(vo, dtl);
        dtl.setBussinessUserId(this.getUserId(request));

        this.consumeDtlService.save(dtl);

        return RespUtil.success();
    }
}
