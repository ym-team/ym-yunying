package com.hmn.ym.web.view;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmn.ym.utils.CachCfgParaUtil;
import com.hmn.ym.utils.CfgParaUtils;
import com.hmn.ym.utils.SendSmsUtils;
import com.hmn.ym.utils.SpringUtils;
import com.hmn.ym.utils.des.DesEncrypt;
import com.hmn.ym.utils.result.JsonResult;

@Controller
public class SendSmsController extends BaseController{
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("sendSms.do")
	public void sendMsg(HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception{
		String captchaCode = request.getParameter("captcha");
		String phoneNum = request.getParameter("tel");
		if (StringUtils.isBlank(captchaCode)) {
			SpringUtils.renderJsonResult(response, JsonResult.ERROR, "验证码输入错误");
			return; 
		}
		String code = SendSmsUtils.randomCode(6);
		DesEncrypt desEnc = new DesEncrypt();
		String randEnc = desEnc.encrypt(code + "");
		Cookie cookie = new Cookie("smsRand", randEnc);
		cookie.setMaxAge(1 * 60);
		response.addCookie(cookie);
		request.getSession().setAttribute("phonevalcode", code + "");
		String content = "您的验证码是：" + code + "。请不要把验证码泄露给其他人。";
		System.out.println("==============验证码是："+content);
		  if(CfgParaUtils.SEND_CODE_VALUE.equals(CachCfgParaUtil.getCfgCache(
		  CfgParaUtils.SEND_CODE) )) { 
//			  SendSmsUtils.sendSms(phoneNum, code);
		  }
		SpringUtils.renderJsonResult(response, JsonResult.SUCCESS, "手机认证短信发送成功");
	}
	
}
