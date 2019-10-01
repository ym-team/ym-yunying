package com.hmn.ym.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmn.ym.dao.entity.po.CustShop;
import com.hmn.ym.service.IShopService;
import com.hmn.ym.service.IUserService;
import com.hmn.ym.utils.SpringUtils;
import com.hmn.ym.utils.result.JsonResult;

import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


/**
 * 
 * 店面信息
 * 业务员邀请店门入驻控制器
 *
 * @author oymw
 */
@Slf4j
@Controller
@RequestMapping("/business/custshop/")
public class CustShopController extends BaseController {
	

    /**
     * 业务员查看我店面列表信息
     */
    private static final String custshoplist = "/custshop/custshoplist";

    /**
     * 业务员邀请店面入驻
     * 新增
     */
    private static final String addstoreenterview = "/custshop/addcustshop";
    /**
     * 业务员查看店门入驻详情
     * 详情
     */
    private static final String queryenterdtl = "/custshop/custshopdtl";
    
    
    /**
     * 店家查询业绩
     */
    private static final String performance= "/custshop/performance";
    
    
    /**
     * 店家我的页面
     */
    private static final String custshopuserindex = "/custshop/custshopuserindex";
    
    @Autowired
    private IShopService shopService;
    
    
    @Autowired
    IUserService userService;
    
    
    /**
     * 业务员查看我的店面列表信息
     * @param request
     * @param response
     * @return
     */
    @GetMapping("queryCustomerListView.do")
    public String queryCustomerListView(HttpServletRequest request, HttpServletResponse response) {
    	log.info("","业务员查看我的店面列表信息");
        return custshoplist;
    }

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
    }


    @RequestMapping(value = "StoreRegister.do")
    public void storeRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	log.info("新增店家");
        Long userId = super.getUserId(request);
        Long userIdNew = this.userService.addUserByPhone(request.getParameter("shopPhone"), userId);
        
        CustShop custShop = new CustShop();
        custShop.setShopName(request.getParameter("shopName"));
        custShop.setShopAddress(request.getParameter("shopAddress"));
        custShop.setShopUserName(request.getParameter("shopUserName"));
        custShop.setShopIdCard(request.getParameter("shopIdCard"));
        custShop.setShopPhone(request.getParameter("shopPhone"));
        custShop.setBussinessUserId(userId);
        custShop.setUserId(Long.valueOf(userIdNew));
        custShop.setShopStatus(1);
        custShop.setShopXieyiStatus(1);
        custShop.setCreateTime(new Date());
        this.shopService.insert(custShop);
        SpringUtils.renderJsonResult(response, JsonResult.SUCCESS, "操作成功");
//        return custshoplist;
    }
    
    /**
     * 我的店面列表信息
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "storeList.do")
    @ResponseBody
    public List<CustShop> storeList(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	Long userId = super.getUserId(request);
    	Example example = new Example(CustShop.class);
    	example.orderBy("createTime").desc();
    	Criteria createCriteria = example.createCriteria();
    	createCriteria.andEqualTo("bussinessUserId", userId);
    	String parameter = request.getParameter("pageNum");
    	PageHelper.startPage(Integer.valueOf(parameter), 10);
    	Page<CustShop> page =(Page<CustShop>) this.shopService.selectByExample(example);
       page.getResult().forEach(o->System.out.println(o.getShopIdCard()));
    	return page.getResult();
    }
    
    /**
     * 业务员查询我的店面详情
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("queryCustShopDtlById")
    public String queryCustShopDtlById(HttpServletRequest request, HttpServletResponse response,Model model) throws IOException {
    	Long userId = super.getUserId(request);
    	Long id= Long.parseLong(request.getParameter("id")+"");
    	Example example = new Example(CustShop.class);
    	Criteria createCriteria = example.createCriteria();
    	createCriteria.andEqualTo("bussinessUserId", userId);
    	createCriteria.andEqualTo("id", id);
    	CustShop custShop = shopService.selectOneByExample(example);
    	log.info("店面名称{}",custShop.getShopName());
    	model.addAttribute("custShop",custShop);
    	return queryenterdtl;
    }
    
    
    /**
     * 店家登录
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "storeLogin.do")
    public String storeLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("店家登录成功后进入我的页面");
        return custshopuserindex;
    }


    /**
     * 店家业绩查询
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "custshopperformance.do")
    public String performance(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	log.info("店家查询自己的业绩");
    	return performance;
    }


    @RequestMapping(value = "teamList.do")
    public String teamList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "/store/team";
    }


}