package com.hmn.ym.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hmn.ym.common.model.BaseResp;
import com.hmn.ym.dao.entity.po.CustAppointment;
import com.hmn.ym.dao.entity.po.CustConsumer;
import com.hmn.ym.dao.entity.po.Hospital;
import com.hmn.ym.dao.entity.po.User;
import com.hmn.ym.dao.entity.vo.CustConsumerVo;
import com.hmn.ym.service.ICustAppointmentService;
import com.hmn.ym.service.ICustConsumerService;
import com.hmn.ym.service.IHospitalService;
import com.hmn.ym.service.IUserService;
import com.hmn.ym.utils.RespUtil;
import com.hmn.ym.utils.SpringUtils;
import com.hmn.ym.utils.result.JsonResult;

import cn.hutool.core.bean.BeanUtil;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/appointMent/")
public class AppointMentController extends BaseController {
	
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
	
	@Autowired
	private ICustConsumerService custConsumerService;
	@Autowired
	private IHospitalService	hospitalService;
	@Autowired
	ICustAppointmentService custAppointmentService;
	



    @GetMapping("detail.do")
    public String detail(HttpServletRequest request, HttpServletResponse response, Model model) {
        String id = request.getParameter("id");
        CustConsumer selectByPrimaryKey = this.custConsumerService.selectByPrimaryKey(id);
        model.addAttribute("custConsumer", selectByPrimaryKey);
        
        List<Hospital> listHospital = this.hospitalService.selectAll();
        model.addAttribute("listHospital", listHospital);
        
        return "/appointment/detail";
    }
    
    
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @RequestMapping("add.do")
    public void add(HttpServletRequest request, HttpServletResponse response, Model model) throws ParseException {
    	
    	CustAppointment custAppointment = new CustAppointment();
    	
    	
    	
    	String consuId = request.getParameter("consuId");
    	String shopId = request.getParameter("shopId");
    	String consuName = request.getParameter("consuName");
    	String consuPhone = request.getParameter("consuPhone");
    	String consuConfirmItem = request.getParameter("consuConfirmItem");
    	String consuYuYueHospital = request.getParameter("consuYuYueHospital");
    	String appointmentTime = request.getParameter("appointmentTime");
    	String jieDaiYuan = request.getParameter("jieDaiYuan");
    	
    	custAppointment.setConsuId(consuId);
    	custAppointment.setShopId(Long.valueOf(shopId));
    	custAppointment.setConsuName(consuName);
    	custAppointment.setConsuPhone(consuPhone);
    	custAppointment.setConsuConfirmItem(consuConfirmItem);
    	custAppointment.setConsuYuYueHospital(consuYuYueHospital);
    	custAppointment.setAppointmentTime(simpleDateFormat.parse(appointmentTime));
    	custAppointment.setJieDaiYuan(jieDaiYuan);
    	Long userId = super.getUserId(request);
    	custAppointment.setBussinessUserId(userId);
    	custAppointment.setConsuStatus(1);
    	
    	this.custAppointmentService.save(custAppointment);
    	
    	SpringUtils.renderJsonResult(response, JsonResult.SUCCESS, "新增成功");
    	

    }
    
    @RequestMapping("list.do")
    public String list(HttpServletRequest request, HttpServletResponse response, Model model){
    	Long userId = super.getUserId(request);
    	Example example = new Example(CustAppointment.class);
    	Criteria createCriteria = example.createCriteria();
    	createCriteria.andEqualTo("bussinessUserId", userId);
    	List<CustAppointment> selectByExample = this.custAppointmentService.selectByExample(example);
    	model.addAttribute("listCustAppointment",selectByExample);
        return "/appointment/list";
    }
    
    
  
    
    
}
