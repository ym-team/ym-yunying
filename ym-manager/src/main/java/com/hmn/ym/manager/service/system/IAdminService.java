package com.hmn.ym.manager.service.system;

import com.hmn.ym.dao.entities.po.Admin;
import com.hmn.ym.dao.entities.po.User;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.system.RoleVo;
import com.hmn.ym.dao.entities.vo.system.AdminRoleVo;
import com.hmn.ym.dao.entities.vo.system.AdminVo;
import com.hmn.ym.manager.service.BaseService;

import java.util.List;

public interface IAdminService extends BaseService<Admin> {

    /**
     * 获取用户分页
     *
     * @param vo
     * @return
     */
    DataTablePage<AdminVo> page(BaseQueryVo vo);

    /**
     * 保存
     *
     * @param vo
     */
    void save(AdminVo vo);


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
    void addAdminRole(AdminRoleVo vo);

    /**
     * 获取用户角色
     *
     * @param adminId
     */
    List<RoleVo> listAdminRoleByAdminId(Integer adminId);

    /**
     * 获取用户
     *
     * @param adminName
     * @return
     */
    Admin getByAdminName(String adminName);


    /**
     * 获取用户权限
     *
     * @param adminName
     * @return
     */
    AdminVo getUserWithRolesPermissions(String adminName);
}
