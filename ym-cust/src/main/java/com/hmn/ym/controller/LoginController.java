package com.hmn.ym.controller;

import com.hmn.ym.common.Constants;
import com.hmn.ym.common.annotation.NotNeedSecurity;
import com.hmn.ym.common.model.BaseResp;
import com.hmn.ym.dao.entity.po.User;
import com.hmn.ym.dao.entity.LoginVo;
import com.hmn.ym.service.user.IUserService;
import com.hmn.ym.utils.Const;
import com.hmn.ym.utils.PasswordUtils;
import com.hmn.ym.utils.RespUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@Controller
public class LoginController extends BaseController {
    @Autowired
    private IUserService userService;

    @GetMapping("login.do")
    @NotNeedSecurity
    public String login(Model model) {
        model.addAttribute("publickey", Const.DES_PUBLIC_ENCRYPT_KEY);
        return "login";
    }

    @PostMapping("login.do")
    @ResponseBody
    @NotNeedSecurity
    public ResponseEntity<BaseResp> login(LoginVo vo, HttpServletRequest request) {
        if (StringUtils.isBlank(vo.getUserAccount())) {
            return RespUtil.failMsg("用户名不能为空！！！");
        }
        if (StringUtils.isBlank(vo.getUserPassword())) {
            return RespUtil.failMsg("密码不能为空！！！");
        }
        User user = userService.getByUserAccount(vo.getUserAccount());
        if (user == null) {
            return RespUtil.failMsg("用户不存在！！！");
        }
        if (user.getStatus() != 1) {
            return RespUtil.failMsg("用户已失效！！！");
        }
        String checkPassword = PasswordUtils.getPassword(vo.getUserPassword());
        if (!user.getPassword().equals(checkPassword)) {
            return RespUtil.failMsg("用户密码错误！！！");
        }
        request.getSession().setAttribute(Constants.ADMIN_USER_SESSION, user);

        return RespUtil.success(user.getType());
    }

    @RequestMapping(value = "foot.do")
    @NotNeedSecurity
    public String footer(HttpServletRequest request, Model model) {
        Map<String, String> param = this.getParameters(request);
        if (param.containsKey("footId")) {
            model.addAttribute("footId", param.get("footId"));
        }
        return "footer";
    }

    @RequestMapping("logout.do")
    @NotNeedSecurity
    public String logout(HttpServletRequest request) {
        for (Enumeration<?> attribute = request.getAttributeNames(); attribute.hasMoreElements(); ) {
            request.getSession().removeAttribute((String) attribute.nextElement());
        }
        request.getSession(false).invalidate();
        return "redirect:/userIndex.do";
    }
}
