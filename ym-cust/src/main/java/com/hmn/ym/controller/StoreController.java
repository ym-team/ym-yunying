package com.hmn.ym.controller;

import com.hmn.ym.dao.entity.po.CustShop;
import com.hmn.ym.dao.entity.po.User;
import com.hmn.ym.service.IShopService;
import com.hmn.ym.service.IUserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    IUserService userService;

    /**
     * 业务员邀请店门入驻
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "StoreEnterView.do")
    public String StoreEnterView(HttpServletRequest request, HttpServletResponse response) {

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
        log.info("业务员邀请店门入驻");

//    	shopService.insert(t)
    }


    @RequestMapping(value = "StoreRegister.do")
    public String storeRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	log.info("新增店家");
        Long userId = super.getUserId(request);
        User user = new User();
        user.setPhone(request.getParameter("shopPhone"));
        user.setType(2);//1：业务员  2：店家 3：消费者
        user.setStatus(1);
        user.setParentId(userId);
        int insert = this.userService.insert(user);
        
        
        CustShop custShop = new CustShop();
        custShop.setShopName(request.getParameter("shopName"));
        custShop.setShopAddress(request.getParameter("shopAddress"));
        custShop.setShopUserName(request.getParameter("shopUserName"));
        custShop.setShopIdCard(request.getParameter("shopIdCard"));
        custShop.setShopPhone(request.getParameter("shopPhone"));
        custShop.setBussinessUserId(user.getId());
        this.shopService.insert(custShop);
       
        return "redirect:/borrow/index.do";
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