package com.hmn.ym.controller;

import com.google.common.collect.Lists;
import com.hmn.ym.dao.entity.po.CustConsumer;
import com.hmn.ym.dao.entity.po.User;
import com.hmn.ym.dao.entity.vo.SaleManVo;
import com.hmn.ym.service.ICustConsumerService;
import com.hmn.ym.service.ISaleManService;
import com.hmn.ym.service.IShopService;
import com.hmn.ym.service.IUserService;
import com.xiaoleilu.hutool.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("performance/")
public class PerformanceController extends BaseController {
    @Autowired
    private ISaleManService saleManService;

    @Autowired
    private IShopService shopService;
    @Autowired
    IUserService userService;

    @Autowired
    ICustConsumerService custConsumerService;

    /**
     * performanceView
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("performanceView.do")
    public String performanceView(HttpServletRequest request, HttpServletResponse response) {

        return "/salesman/performance";
    }

    @GetMapping("teamView.do")
    public String teamView(HttpServletRequest request, Model model) {
        List<SaleManVo> resultList = Lists.newArrayList();
        User user = this.getUser(request);
        List<SaleManVo> saleMans = saleManService.getByParentId(user.getId());
        for (SaleManVo vo : saleMans) {
            resultList.add(vo);
            List<SaleManVo> inviteUserList = saleManService.getByParentId(vo.getUserId());
            if (CollectionUtil.isNotEmpty(inviteUserList)) {
                resultList.addAll(inviteUserList);
            }
        }
        model.addAttribute("saleMans", resultList);

        return "/salesman/team";
    }


    @GetMapping("myCustView.do")
    public String myCustView(HttpServletRequest request, HttpServletResponse response, Model model) {
        //Long userId = super.getUserId(request);
        User user = super.getUser(request);
        String view = "";
        Example example = new Example(CustConsumer.class);
        example.orderBy("createTime").desc();
        Criteria createCriteria = example.createCriteria();
        if (user.getType() == 1) {
            createCriteria.andEqualTo("bussinessUserId", user.getId());
            view = "/salesman/mycust";//业务员查看
        } else if (user.getType() == 2) {
            createCriteria.andEqualTo("shopId", user.getId());
            view = "/customer/mycustList";//店面查看
        }
        //List<CustShop> listCustShop = this.shopService.selectByExample(example);
        List<CustConsumer> selectByExample = this.custConsumerService.selectByExample(example);
        model.addAttribute("listCustConsumer", selectByExample);
        return view;
    }


    @GetMapping("consumerDetail.do")
    public String consumerDetail(HttpServletRequest request, HttpServletResponse response, Model model) {
        String id = request.getParameter("id");
        CustConsumer selectByPrimaryKey = this.custConsumerService.selectByPrimaryKey(id);
        model.addAttribute("custConsumer", selectByPrimaryKey);
        return "/customer/customerView";
    }

    @GetMapping("myCustomerView.do")
    public String myCustomerView(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "/salesman/mycustomer";
    }


    @RequestMapping(value = "salesmanindex.do")
    public String salesmanindex(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "/salesman/salesmanindex";
    }
}
