package com.hmn.ym.manager.service.system;


import com.hmn.ym.dao.entities.po.system.Role;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.system.RoleVo;
import com.hmn.ym.manager.service.BaseService;

public interface IRoleService extends BaseService<Role> {

    /**
     * 获取角色分页
     *
     * @param vo
     * @return
     */
    DataTablePage<Role> page(BaseQueryVo vo);

    /**
     * 保存角色
     *
     * @param vo
     */
    void save(RoleVo vo);


    /**
     * 删除角色
     *
     * @param id
     */
    void delete(Integer id);
}
