package com.hmn.ym.manager.web.view.system;

import com.hmn.ym.manager.service.system.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private IRoleService roleService;

    @GetMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("roles", roleService.selectAll());

        return "/system/user-list";
    }
}
