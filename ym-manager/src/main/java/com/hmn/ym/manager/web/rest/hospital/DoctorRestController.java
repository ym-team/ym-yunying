package com.hmn.ym.manager.web.rest.hospital;

import com.hmn.ym.common.model.BaseResp;
import com.hmn.ym.dao.entities.po.hospital.Doctor;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.hospital.DoctorVo;
import com.hmn.ym.dao.entities.vo.system.RoleVo;
import com.hmn.ym.manager.service.hospital.IDoctorService;
import com.hmn.ym.manager.utils.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/doctor")
public class DoctorRestController {
    @Autowired
    private IDoctorService doctorService;

    @RequestMapping(value = "/list")
    public DataTablePage<Doctor> list(Model model, BaseQueryVo vo) {
        return doctorService.page(vo);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<BaseResp> save(DoctorVo vo) {
        doctorService.save(vo);

        return RespUtil.success();
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<BaseResp> delete(Integer id) {
        doctorService.delete(id);

        return RespUtil.success();
    }
}
