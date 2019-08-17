package com.hmn.ym.manager.web.rest.shop;

import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.shop.SalesManVo;
import com.hmn.ym.manager.service.shop.ISalesManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/salesMan")
public class SalesManRestController {
    @Autowired
    private ISalesManService salesManService;

    @RequestMapping(value = "/page")
    public DataTablePage<SalesManVo> page(BaseQueryVo vo) {
        return salesManService.page(vo);
    }
}
