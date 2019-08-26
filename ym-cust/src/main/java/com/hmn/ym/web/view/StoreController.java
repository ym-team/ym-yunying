package com.hmn.ym.web.view;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("store/")
public class StoreController extends BaseController{

	public static final String storeenterview = "/store/enterview";
	
	/**
	 * 业务员邀请店门入驻
	 * 二维码方式
	 */
	@RequestMapping(value = "StoreEnterView.do")
	public String StoreEnterView(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("store");
		
		return storeenterview;
	}
	
	
	@RequestMapping(value = "StoreRegister.do")
	public String storeRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("入驻成功");
		return "redirect:/index.do";
	}
	
	
	@RequestMapping(value = "storeLogin.do")
	public String storeLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("店家登录成功");
		return "/store/userIndex";
	}
	
	
	@RequestMapping(value = "performanceList.do")
	public String performance(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "/store/performance";
	}
	
	
	@RequestMapping(value = "teamList.do")
	public String teamList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "/store/team";
	}
	
	
}