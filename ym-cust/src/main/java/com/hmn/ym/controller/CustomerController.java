package com.hmn.ym.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hmn.ym.common.model.BaseResp;
import com.hmn.ym.dao.entity.po.CustConsumer;
import com.hmn.ym.dao.entity.po.User;
import com.hmn.ym.dao.entity.vo.CustConsumerVo;
import com.hmn.ym.service.ICustConsumerService;
import com.hmn.ym.service.IUserService;
import com.hmn.ym.utils.RespUtil;

import cn.hutool.core.bean.BeanUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/customer/")
public class CustomerController extends BaseController {
	
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private IUserService userService;
	
	@Autowired
	private ICustConsumerService custConsumerService;
	
	
	private static final String customeradd="/customer/customerAddView";

    @GetMapping("toCustomerAddView.do")
    public String toCustomerAddView() {
    	logger.info("邀请填写消费者");
        return customeradd;
    }
    
    
    @ResponseBody
    @RequestMapping(value = "toCustomerAdd.do")
    public ResponseEntity<BaseResp> toCustomerAdd(CustConsumerVo custConsumerVo,HttpServletRequest request) throws IOException {
    	CustConsumer custConsumer = new CustConsumer();
    	BeanUtil.copyProperties(custConsumerVo, custConsumer);
    	logger.info("aaa:"+ JSON.toJSONString(custConsumer));
    	Long userId = super.getUserId(request);
    	custConsumer.setShopId(userId);
    	User selectByPrimaryKey = this.userService.selectByPrimaryKey(userId);
    	custConsumer.setBussinessUserId(selectByPrimaryKey.getParentId());
    	this.custConsumerService.save(custConsumer);
        return RespUtil.success();
    }
     
    @RequestMapping(value = "list.do")
    public String list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "/customer/mycustList";
    }


    @RequestMapping(value = "detail.do")
    public String detail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "/store/customDetail";
    }

    @RequestMapping(value = "appointment.do")
    public String appointment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "/customer/appointment";
    }

    @RequestMapping(value = "appointmentList.do")
    public String appointmentList() {
        return "/customer/appointmentList";
    }
}
