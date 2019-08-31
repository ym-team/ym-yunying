package com.hmn.ym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("customer/")
public class CustomerController extends BaseController {

    @GetMapping("toAdd.do")
    public String toAdd() {
        return "/customer/customerView";
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
