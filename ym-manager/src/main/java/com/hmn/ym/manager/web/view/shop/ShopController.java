package com.hmn.ym.manager.web.view.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/shop")
public class ShopController {

    @GetMapping(value = "/list")
    public String list() {
        return "/shop/shop-list";
    }
}
