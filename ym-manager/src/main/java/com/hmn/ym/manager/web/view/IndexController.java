package com.hmn.ym.manager.web.view;

import com.hmn.ym.dao.entities.vo.ShiroUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 首页管理
 */
@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping(value = "/")
    public String index(HttpServletRequest request) {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        request.getSession().setAttribute("userName", user.getName());
        return "index";
    }

    @GetMapping(value = "/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(String userName, String password) {
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(userName);
        token.setPassword(password.toCharArray());
        token.setRememberMe(true);
        try {
            user.login(token);
            return "redirect:/";
        } catch (AuthenticationException e) {
            token.clear();
            logger.error("用户登录异常 " + e.getMessage(), e);
        }
        return "redirect:/login";
    }
}