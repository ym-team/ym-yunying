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
import com.hmn.ym.service.IConsumeDtlService;
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
import java.util.stream.Collectors;

@Controller
@RequestMapping("/myMoney/")
public class MyMoneyController extends BaseController {
	
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
	
	@Autowired
	private ICustConsumerService custConsumerService;
	@Autowired
	private IHospitalService	hospitalService;
	@Autowired
	ICustAppointmentService custAppointmentService;
	@Autowired
	IConsumeDtlService consumeDtlService; 
	
	@Autowired
	IUserService userService;


    @GetMapping("myMoney.do")
    public void myMoney(HttpServletRequest request, HttpServletResponse response, Model model) {
        String id = request.getParameter("id");
        Long userId = super.getUserId(request);
        double queryMyMoneyByThisMonth = this.consumeDtlService.queryMyMoneyByThisMonth(userId);
        System.out.println("queryMyMoneyByThisMonth:"+queryMyMoneyByThisMonth);
    }
    
    
    
    @GetMapping("myTeamMoney.do")
    public void myTeamMoney(HttpServletRequest request, HttpServletResponse response, Model model) {
        String id = request.getParameter("id");
        Long userId = super.getUserId(request);
        
        Example example = new Example(User.class);
        Criteria createCriteria = example.createCriteria();
        createCriteria.andEqualTo("parentId", userId);
        List<User> selectByExample = this.userService.selectByExample(example);
        
        List<Long> listUserId = selectByExample.parallelStream().map(User::getParentId).collect(Collectors.toList());
        
        Example example2 = new Example(User.class);
        Criteria createCriteria2 = example2.createCriteria();
        createCriteria2.andIn("parentId", listUserId);
        List<User> selectByExample2 = this.userService.selectByExample(example2);
        
        
        List<Long> listUserId2 = selectByExample2.parallelStream().map(User::getParentId).collect(Collectors.toList());
        
        listUserId.add(userId);
        listUserId2.addAll(listUserId);
        
        double myTeamMoney = this.consumeDtlService.myTeamMoney(listUserId2);
    }
    
    
    
    
}
