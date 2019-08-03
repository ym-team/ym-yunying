package com.hmn.ym.manager.service.system;


import com.hmn.ym.dao.entities.po.system.User;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.system.RoleVo;
import com.hmn.ym.dao.entities.vo.system.UserRoleVo;
import com.hmn.ym.dao.entities.vo.system.UserVo;
import com.hmn.ym.manager.service.BaseService;

import java.util.List;

public interface IUserService extends BaseService<User> {

    /**
     * 获取用户分页
     *
     * @param vo
     * @return
     */
    DataTablePage<UserVo> page(BaseQueryVo vo);

    /**
     * 保存
     *
     * @param vo
     */
    void save(UserVo vo);


    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 添加用户角色
     *
     * @param vo
     */
    void addUserRole(UserRoleVo vo);

    /**
     * 获取用户角色
     *
     * @param userId
     */
    List<RoleVo> listUserRoleByUserId(Integer userId);

    /**
     * 获取用户
     *
     * @param userName
     * @return
     */
    User getByUserName(String userName);


    /**
     * 获取用户权限
     *
     * @param userName
     * @return
     */
    UserVo getUserWithRolesPermissions(String userName);
}
