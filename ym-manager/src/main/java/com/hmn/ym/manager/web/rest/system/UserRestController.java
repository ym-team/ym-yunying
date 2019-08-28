package com.hmn.ym.manager.web.rest.system;

import com.hmn.ym.common.model.BaseResp;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.system.AdminRoleVo;
import com.hmn.ym.dao.entities.vo.system.AdminVo;
import com.hmn.ym.manager.service.system.IAdminService;
import com.hmn.ym.manager.utils.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {
    @Autowired
    private IAdminService userService;

    @RequestMapping(value = "/list")
    public DataTablePage<AdminVo> list(BaseQueryVo vo) {
        return userService.page(vo);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<BaseResp> save(AdminVo vo) {
        userService.save(vo);

        return RespUtil.success();
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<BaseResp> delete(Integer id) {
        userService.delete(id);

        return RespUtil.success();
    }

    @PostMapping(value = "/addUserRole")
    public ResponseEntity<BaseResp> addUserRole(AdminRoleVo vo) {
        userService.addAdminRole(vo);

        return RespUtil.success();
    }
}
