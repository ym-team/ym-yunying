package com.hmn.ym.manager.service.system.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.hmn.ym.dao.entities.po.system.Role;
import com.hmn.ym.dao.entities.po.system.User;
import com.hmn.ym.dao.entities.po.system.UserRole;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.system.RoleVo;
import com.hmn.ym.dao.entities.vo.system.UserRoleVo;
import com.hmn.ym.dao.entities.vo.system.UserVo;
import com.hmn.ym.dao.mapper.system.RoleMapper;
import com.hmn.ym.dao.mapper.system.UserMapper;
import com.hmn.ym.dao.mapper.system.UserRoleMapper;
import com.hmn.ym.manager.service.BaseServiceImpl;
import com.hmn.ym.manager.service.system.IUserService;
import com.hmn.ym.manager.utils.ConvertUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public DataTablePage<UserVo> page(BaseQueryVo vo) {
        PageHelper.startPage(vo.getStart(), vo.getLength());
        Page<User> page = (Page<User>) userMapper.selectAll();
        List<UserVo> list = Lists.newArrayList();
        for (User user : page.getResult()) {
            UserVo uVo = new UserVo();
            BeanUtils.copyProperties(user, uVo);
            uVo.setUserRoles(this.listUserRoleByUserId(user.getId()));
            uVo.setRoleNames(ConvertUtil.convertUserRoleNames(uVo.getUserRoles()));

            list.add(uVo);
        }
        return new DataTablePage<UserVo>(vo.getDraw(), (int) page.getTotal(), list);
    }

    @Transactional
    @Override
    public void save(UserVo vo) {
        if (vo.getId() != null) {
            User exit = userMapper.selectByPrimaryKey(vo.getId());
            if (!exit.getName().equals(vo.getName())) {
                this.exit(vo.getName());
            }
            User user = new User();
            BeanUtils.copyProperties(vo, user);
            user.setUpdateTime(new Date());

            userMapper.updateByPrimaryKeySelective(user);
        } else {
            this.exit(vo.getName());

            User user = new User();
            BeanUtils.copyProperties(vo, user);
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());

            userMapper.insertSelective(user);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        //删除用户
        userMapper.deleteByPrimaryKey(id);
        //删除用户角色
        userRoleMapper.deleteByUserId(id);
    }

    @Transactional
    @Override
    public void addUserRole(UserRoleVo vo) {
        //先删除用户角色
        userRoleMapper.deleteByUserId(vo.getUserId());
        //再添加用户角色
        for (String roleId : vo.getRoleIds().split(",")) {
            UserRole ur = new UserRole();
            ur.setRoleId(Integer.parseInt(roleId));
            ur.setUserId(vo.getUserId());
            userRoleMapper.insertSelective(ur);
        }
    }

    @Override
    public List<RoleVo> listUserRoleByUserId(Integer userId) {
        List<Role> roles = roleMapper.selectByUserId(userId);
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
    public User getByUserName(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("name", userName);
        return userMapper.selectOneByExample(example);
    }

    @Override
    public UserVo getUserWithRolesPermissions(String userName) {
        return userMapper.getUserWithRolesPermissions(userName);
    }

    private void exit(String userName) {
        User user = this.getByUserName(userName);
        if (user != null) {
            throw new RuntimeException("该用户已经存在.");
        }
    }
}
