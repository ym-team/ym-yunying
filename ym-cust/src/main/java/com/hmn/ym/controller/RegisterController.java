package com.hmn.ym.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.hmn.ym.common.Constants;
import com.hmn.ym.common.annotation.NotNeedSecurity;
import com.hmn.ym.dao.entity.po.User;
import com.hmn.ym.dao.entity.vo.FindPasswordVo;
import com.hmn.ym.dao.entity.vo.RegisterVo;
import com.hmn.ym.service.IUserService;
import com.hmn.ym.utils.Assert;
import com.hmn.ym.utils.Const;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 用户注册信息
 *
 * @author oymw
 */

@Controller
public class RegisterController extends BaseController {
    private static final String CAPTCHA_SESSION = "CAPTCHA_SESSION";
    @Autowired
    private IUserService userService;

    /**
     * 注册页面——》第一步
     */
    @NotNeedSecurity
    @RequestMapping(value = "toRegister.do")
    public String toRegister(HttpServletRequest request, Model model) {
        model.addAttribute("publickey", Const.DES_PUBLIC_ENCRYPT_KEY);
        model.addAttribute("u", request.getParameter("u"));
        return "register";
    }

    /**
     * 注册填写密码——》注册第二步
     */
    @RequestMapping(value = "toNext.do")
    @NotNeedSecurity
    public String toNext(HttpServletRequest request, Model model) {
        Map<String, String> param = this.getParameters(request);
        if (!param.containsKey("userPhone")) {
            model.addAttribute("message", "手机号不能为空");
            return "register";
        }
        if (!isPhone(param.get("userPhone"))) {
            model.addAttribute("message", "手机号格式错误");
            return "register";
        }
        String smsCode = this.getSmsCode(request);
        if (StringUtils.isBlank(smsCode)) {
            model.addAttribute("message", "验证码过期");
            return "register";
        }
        if (!smsCode.equals(param.get("smsCode"))) {
            model.addAttribute("message", "验证码错误");
            return "register";
        }
        model.addAttribute("inviteUserid", param.get("u"));
        model.addAttribute("userPhone", param.get("userPhone"));
        model.addAttribute("userAccount", param.get("userAccount"));
        model.addAttribute("publickey", Const.DES_PUBLIC_ENCRYPT_KEY);

        return "register2";
    }

    @RequestMapping("register.do")
    @NotNeedSecurity
    public String register(RegisterVo vo, HttpServletRequest request, Model model) {
        User inviteUser = userService.getByInviteCode(vo.getInviteUserid());
        if (inviteUser == null) {
            model.addAttribute("message", "邀请码不存在.");
            return "register2";
        }
        User user = userService.register(vo);
        //设置seesion
        request.getSession().setAttribute(Constants.ADMIN_USER_SESSION, user);

        return "redirect:/user/userIndex.do";
    }

    @RequestMapping("getProtocol.do")
    @NotNeedSecurity
    public String getProtocol(Model model) {
        model.addAttribute("protocol", "");
        return "protocol";
    }

    @RequestMapping("captcha.do")
    @NotNeedSecurity
    public void captcha(HttpServletRequest req, HttpServletResponse resp) {
        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 10);
        // 将图像输出到Servlet输出流中。
        try {
            captcha.write(resp.getOutputStream());
        } catch (Exception e) {
            logger.error("获取验证码异常." + e.getMessage(), e);
        }
        req.getSession().setAttribute(CAPTCHA_SESSION, captcha.getCode().toUpperCase());
    }

    @NotNeedSecurity
    @RequestMapping(value = "toFindPassword.do")
    public String toFindPassword(Model model) {
        model.addAttribute("publickey", Const.DES_PUBLIC_ENCRYPT_KEY);

        return "findPassword";
    }

    @NotNeedSecurity
    @RequestMapping(value = "resetPassword.do")
    public String resetPassword(FindPasswordVo vo, HttpServletRequest request, Model model) {
        try {
            Assert.isNotBlank(vo.getUserPhone(), "手机号码必填");
            Assert.isNotBlank(vo.getCaptcha(), "验证码必填");
            String smsCode = this.getSmsCode(request);
            Assert.isNotBlank(smsCode, "短信验证码已过期");
            Assert.isTrue(smsCode.equals(vo.getSmsCode()), "短信验证码错误");

            userService.resetPassword(vo);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "redirect:/toFindPassword.do";
        }
        return "redirect:/login.do";
    }
}
