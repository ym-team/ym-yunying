package com.hmn.ym.manager.web.rest.system;

import com.hmn.ym.common.model.BaseResp;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.system.UserRoleVo;
import com.hmn.ym.dao.entities.vo.system.UserVo;
import com.hmn.ym.manager.service.system.IUserService;
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
    private IUserService userService;

    @RequestMapping(value = "/list")
    public DataTablePage<UserVo> list(BaseQueryVo vo) {
        return userService.page(vo);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<BaseResp> save(UserVo vo) {
        userService.save(vo);

        return RespUtil.success();
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<BaseResp> delete(Integer id) {
        userService.delete(id);

        return RespUtil.success();
    }

    @PostMapping(value = "/addUserRole")
    public ResponseEntity<BaseResp> addUserRole(UserRoleVo vo) {
        userService.addUserRole(vo);

        return RespUtil.success();
    }
}
