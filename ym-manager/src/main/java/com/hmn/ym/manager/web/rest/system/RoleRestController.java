package com.hmn.ym.manager.web.rest.system;

import com.hmn.ym.common.model.BaseResp;
import com.hmn.ym.dao.entities.po.system.Role;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.system.RoleVo;
import com.hmn.ym.manager.service.system.IRoleService;
import com.hmn.ym.manager.utils.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/role")
public class RoleRestController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = "/list")
    public DataTablePage<Role> list(Model model, BaseQueryVo vo) {
        return roleService.page(vo);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<BaseResp> save(RoleVo vo) {
        roleService.save(vo);

        return RespUtil.success();
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<BaseResp> delete(Integer id) {
        roleService.delete(id);

        return RespUtil.success();
    }
}
