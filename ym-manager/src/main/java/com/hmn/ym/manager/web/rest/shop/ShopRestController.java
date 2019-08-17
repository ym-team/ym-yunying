package com.hmn.ym.manager.web.rest.shop;

import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.hospital.DoctorVo;
import com.hmn.ym.dao.entities.vo.shop.ShopVo;
import com.hmn.ym.manager.service.shop.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/shop")
public class ShopRestController {
    @Autowired
    private IShopService shopService;

    @RequestMapping(value = "/page")
    public DataTablePage<ShopVo> page(BaseQueryVo vo) {
        return shopService.page(vo);
    }
}
