package com.hmn.ym.controller;

import com.hmn.ym.utils.SpringUtils;
import com.hmn.ym.utils.result.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController extends BaseController {
	
	/**
	 * 登录页面
	 */
	private static final String login_view = "login";
	
	/**
	 * 登录成功后进入主页面
	 */
	private static final String user_login_view = "user/userIndex";
	
	
	@RequestMapping("index.do")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		logger.info("login");
		return login_view;
	}
	
	@RequestMapping("login.do")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, String> param = this.getParameters(request);
		String code = "";
		String msg = "";
			if (!param.containsKey("userAccount")) {
				code = "300";
				msg = "用户名不能为空！！！";
			}
			if (!param.containsKey("userPassword")) {
				code = "300";
				msg = "密码不能为空！！！";
			}
			String userAccount = param.get("userAccount");
			
		
//			DesEncrypt desEncrpt = new DesEncrypt(Const.DES_PUBLIC_ENCRYPT_KEY);
//			DesEncrypt aesEncrypt = new DesEncrypt(Const.DES_PRIVATE_ENCRYPT_KEY);
//			String userPassword = desEncrpt.decrypt(param.get("userPassword"));
//			String checkpassword = MD5Utils.stringToMD5(aesEncrypt.encrypt(userPassword));
			Map<String,String> params = new HashMap<String,String>();
			params.put("userPhone", userAccount);
			
						code = JsonResult.SUCCESS;
						msg = "登录成功";
						
		if("13751768919".equals(userAccount)){
			System.out.println("4444444444");
			code = "3";
		}
		System.out.println(msg);
		SpringUtils.renderJsonResult(response, code, msg);
	
	}
	
	/**
	 * 进入个人主页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("userLogin.do")
	public String userIndex(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("index");

		return user_login_view;
	}
	
	
	/**
	 * 底部菜单显示
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "foot.do")
	public String foot(HttpServletRequest request, HttpServletResponse response, Model model){
		Map<String, String> param = this.getParameters(request);
		if(param.containsKey("footId")){
			model.addAttribute("footId", param.get("footId"));
		}
		return "footer";
	}
	
	
	/**
	 * 退出登录
	 */
	@RequestMapping("layout.do")
	public String layout(HttpServletRequest request, HttpServletResponse response, Model model) {
			return "redirect:/index.do";
		}
	

}
