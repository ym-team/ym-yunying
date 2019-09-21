package com.hmn.ym.controller;

import com.hmn.ym.service.IShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 业务员邀请店门入驻控制器
 *
 * @author oymw
 */
@Slf4j
@Controller
@RequestMapping("/business/store/")
public class StoreController extends BaseController {

    /**
     * 业务员邀请入驻
     */
    private static final String addstoreenterview = "/business/addenterview";
    /**
     * 业务员查看店门入驻详情
     */
    private static final String queryenterdtl = "business/enterdtl";
    @Autowired
    private IShopService shopService;

    /**
     * 业务员邀请店门入驻
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "StoreEnterView.do")
    public String StoreEnterView(HttpServletRequest request, HttpServletResponse response) {
        log.info("业务员邀请店门入驻");

        return addstoreenterview;
    }


    /**
     * 新增
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "saveEnter.do")
    public void saveEnter(HttpServletRequest request, HttpServletResponse response) {

//    	shopService.insert(t)
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