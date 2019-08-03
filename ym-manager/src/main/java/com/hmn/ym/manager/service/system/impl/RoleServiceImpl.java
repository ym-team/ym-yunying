package com.hmn.ym.manager.service.system.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmn.ym.dao.entities.po.system.Role;
import com.hmn.ym.dao.entities.po.system.RolePermission;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.system.RoleVo;
import com.hmn.ym.dao.mapper.system.RoleMapper;
import com.hmn.ym.dao.mapper.system.RoleMenuMapper;
import com.hmn.ym.dao.mapper.system.RolePermissionMapper;
import com.hmn.ym.dao.mapper.system.UserRoleMapper;
import com.hmn.ym.manager.service.BaseServiceImpl;
import com.hmn.ym.manager.service.system.IRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleMapper> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public DataTablePage<Role> page(BaseQueryVo vo) {
        PageHelper.startPage(vo.getStart(), vo.getLength());
        Page<Role> page = (Page<Role>) roleMapper.selectAll();
        return new DataTablePage<Role>(vo.getDraw(), (int) page.getTotal(), page.getResult());
    }

    @Override
    public List<Role> list() {
        return roleMapper.selectAll();
    }

    @Transactional
    @Override
    public void save(RoleVo vo) {
        if (vo.getId() != null) {
            Role exit = roleMapper.selectByPrimaryKey(vo.getId());
            if (!exit.getName().equals(vo.getName())) {
                this.exit(vo.getName());
            }
            Role role = new Role();
            BeanUtils.copyProperties(vo, role);

            roleMapper.updateByPrimaryKeySelective(role);
        } else {
            this.exit(vo.getName());

            Role role = new Role();
            BeanUtils.copyProperties(vo, role);
            role.setCreateTime(new Date());

            roleMapper.insertSelective(role);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        //删除角色
        roleMapper.deleteByPrimaryKey(id);
        //删除角色用户
        userRoleMapper.deleteByRoleId(id);
        //删除角色菜单
        roleMenuMapper.deleteByRoleId(id);
        //删除角色按钮
        Example example = new Example(RolePermission.class);
        example.createCriteria().andEqualTo("roleId", id);
        rolePermissionMapper.deleteByExample(example);
    }

    private void exit(String roleName) {
        Example example = new Example(Role.class);
        example.createCriteria().andEqualTo("name", roleName);
        Role role = roleMapper.selectOneByExample(example);
        if (role != null) {
            throw new RuntimeException("该角色已经存在.");
        }
    }
}
