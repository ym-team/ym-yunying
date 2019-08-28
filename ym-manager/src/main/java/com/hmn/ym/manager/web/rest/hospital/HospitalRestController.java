package com.hmn.ym.manager.web.rest.hospital;

import com.hmn.ym.common.model.BaseResp;
import com.hmn.ym.dao.entities.po.Hospital;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.hospital.HospitalVo;
import com.hmn.ym.manager.service.hospital.IHospitalService;
import com.hmn.ym.manager.utils.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/hospital")
public class HospitalRestController {
    @Autowired
    private IHospitalService hospitalService;

    @RequestMapping(value = "/page")
    public DataTablePage<Hospital> page(Model model, BaseQueryVo vo) {
        return hospitalService.page(vo);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<BaseResp> save(HospitalVo vo) {
        hospitalService.save(vo);

        return RespUtil.success();
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<BaseResp> delete(Integer id) {
        hospitalService.delete(id);

        return RespUtil.success();
    }
}
