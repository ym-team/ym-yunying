package com.hmn.ym.manager.service.system.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.hmn.ym.dao.entities.po.Admin;
import com.hmn.ym.dao.entities.po.AdminRole;
import com.hmn.ym.dao.entities.po.Role;
import com.hmn.ym.dao.entities.po.Admin;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.system.RoleVo;
import com.hmn.ym.dao.entities.vo.system.AdminRoleVo;
import com.hmn.ym.dao.entities.vo.system.AdminVo;
import com.hmn.ym.dao.mapper.AdminMapper;
import com.hmn.ym.dao.mapper.AdminRoleMapper;
import com.hmn.ym.dao.mapper.RoleMapper;
import com.hmn.ym.manager.service.BaseServiceImpl;
import com.hmn.ym.manager.service.system.IAdminService;
import com.hmn.ym.manager.utils.ConvertUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminMapper> implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public DataTablePage<AdminVo> page(BaseQueryVo vo) {
        PageHelper.startPage(vo.getStart(), vo.getLength());
        Page<Admin> page = (Page<Admin>) adminMapper.selectAll();
        List<AdminVo> list = Lists.newArrayList();
        for (Admin admin : page.getResult()) {
            AdminVo uVo = new AdminVo();
            BeanUtils.copyProperties(admin, uVo);
            uVo.setAdminRoles(this.listAdminRoleByAdminId(admin.getId()));
            uVo.setRoleNames(ConvertUtil.convertAdminRoleNames(uVo.getAdminRoles()));

            list.add(uVo);
        }
        return new DataTablePage<AdminVo>(vo.getDraw(), (int) page.getTotal(), list);
    }

    @Transactional
    @Override
    public void save(AdminVo vo) {
        if (vo.getId() != null) {
            Admin exit = adminMapper.selectByPrimaryKey(vo.getId());
            if (!exit.getName().equals(vo.getName())) {
                this.exit(vo.getName());
            }
            Admin admin = new Admin();
            BeanUtils.copyProperties(vo, admin);
            admin.setUpdateTime(new Date());

            adminMapper.updateByPrimaryKeySelective(admin);
        } else {
            this.exit(vo.getName());

            Admin admin = new Admin();
            BeanUtils.copyProperties(vo, admin);
            admin.setCreateTime(new Date());
            admin.setUpdateTime(new Date());

            adminMapper.insertSelective(admin);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        //删除用户
        adminMapper.deleteByPrimaryKey(id);
        //删除用户角色
        //userRoleMapper.deleteByAdminId(id);
    }

    @Transactional
    @Override
    public void addAdminRole(AdminRoleVo vo) {
        //先删除用户角色
        //userRoleMapper.deleteByAdminId(vo.getAdminId());
        //再添加用户角色
        for (String roleId : vo.getRoleIds().split(",")) {
            AdminRole ur = new AdminRole();
            ur.setRoleId(Integer.parseInt(roleId));
            ur.setAdminId(vo.getAdminId());
            userRoleMapper.insertSelective(ur);
        }
    }

    @Override
    public List<RoleVo> listAdminRoleByAdminId(Integer adminId) {
        List<Role> roles = Lists.newArrayList();//roleMapper.selectByUserId(adminId);
        List<RoleVo> list = Lists.newArrayList();
        for (Role role : roles) {
            RoleVo vo = new RoleVo();
            if (role != null) {
                BeanUtils.copyProperties(role, vo);
                list.add(vo);
            }
        }
        return list;
    }

    @Override
    public Admin getByAdminName(String adminName) {
        Example example = new Example(Admin.class);
        example.createCriteria().andEqualTo("name", adminName);
        return adminMapper.selectOneByExample(example);
    }

    @Override
    public AdminVo getUserWithRolesPermissions(String adminName) {
        return null;//adminMapper.getUserWithRolesPermissions(userName);
    }

    private void exit(String userName) {
        Admin admin = this.getByAdminName(userName);
        if (admin != null) {
            throw new RuntimeException("该用户已经存在.");
        }
    }
}
