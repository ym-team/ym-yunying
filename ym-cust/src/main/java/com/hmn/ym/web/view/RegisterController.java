package com.hmn.ym.web.view;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmn.ym.utils.Const;
import com.hmn.ym.utils.des.DesEncrypt;

/**
 * 用户注册信息
 * @author oymw
 *
 */

@Controller
public class RegisterController extends BaseController{
	
	/**
	 * 注册第一步 进入填写密码页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	public static final String register = "register" ;
	
	
	/**
	 * 注册第2步
	 */
	public static final String register2 = "register2" ;
	

	/**
	 * 用户注册成功后跳转用户页面
	 */
	public static final String userIndex = "user/userIndex";
	
	/**
	 * 注册协议
	 */
	public static final String protocol = "protocol";
	
	
	/**
	 * 注册页面第一步
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "toRegister.do")
	public String toRegister( HttpServletRequest request, Model model) {
		model.addAttribute("publickey", Const.DES_PUBLIC_ENCRYPT_KEY);
		model.addAttribute("u", request.getParameter("u"));
		return register;
	}
	
	
	/**
	 * 注册填写密码
	 * 注册第二步
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "toNext.do")
	public String toNext(HttpServletRequest request, HttpServletResponse response, Model model) {
		Map<String, String> param = this.getParameters(request);
		if (!param.containsKey("userPhone")) {
			model.addAttribute("message", "手机号不能为空");
			return register;
		}
		if (!isPhone(param.get("userPhone"))) {
			model.addAttribute("message", "手机号格式错误");
			return register;
		}
		String phoneNum= param.get("userPhone");
		Map<String,String> params = new HashMap<String,String>();
		params.put("userPhone", phoneNum);
		DesEncrypt desEncrypt = new DesEncrypt();
		String smsCode = null;
		Cookie[] cookie = request.getCookies();
		for (int i = 0; i < cookie.length; i++) {
			Cookie cook = cookie[i];
			if (cook.getName().equalsIgnoreCase("smsRand")) { // 获取键
				smsCode = desEncrypt.decrypt(cook.getValue().toString()); // 获取值
				break;
			}
		}
		if ("".equals(smsCode) || null == smsCode) {
			model.addAttribute("message", "验证码过期");
			return register;
		}
		if (!smsCode.equals(param.get("smsCode"))) {
			model.addAttribute("message", "验证码错误");
			return register;
		}
		model.addAttribute("inviteUserid", param.get("u"));
		model.addAttribute("userPhone", param.get("userPhone"));
		model.addAttribute("userAccount", param.get("userAccount"));
		model.addAttribute("publickey", Const.DES_PUBLIC_ENCRYPT_KEY);
	
		return register2;
	}
	
	
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("register.do")
	public String register(HttpServletRequest request, HttpServletResponse response, Model model) {
		Map<String, String> param = this.getParameters(request);
		
		
		return userIndex;
	}
	
	
	
	/**
	 * 注册协议
	 */
	@RequestMapping("getProtocol.do")
	public String getProtocol(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("protocol","");
		return protocol;
	}

}
