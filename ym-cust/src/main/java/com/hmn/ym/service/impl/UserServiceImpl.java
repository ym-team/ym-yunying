package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.SaleMan;
import com.hmn.ym.dao.entity.po.User;
import com.hmn.ym.dao.entity.vo.FindPasswordVo;
import com.hmn.ym.dao.entity.vo.RegisterVo;
import com.hmn.ym.dao.mapper.UserMapper;
import com.hmn.ym.service.ISaleManService;
import com.hmn.ym.service.IUserService;
import com.hmn.ym.utils.InviteCodeGenerator;
import com.hmn.ym.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ISaleManService saleManService;

    @Transactional
    @Override
    public User register(RegisterVo vo) {
        this.exit(vo.getUserPhone());

        User user = new User();
        user.setPhone(vo.getUserPhone());
        user.setPassword(vo.getUserPassword());
        user.setType(1);
        user.setInviteCode(this.getInviteCode());
        User parent = this.getByInviteCode(vo.getInviteUserid());
        if (parent != null) {
            user.setParentId(parent.getId());
        }
        user.setPassword(PasswordUtils.getPassword(user.getPassword()));
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insertSelective(user);

        SaleMan saleMan = new SaleMan();
        saleMan.setUserId(user.getId());
        saleMan.setPhone(user.getPhone());
        saleMan.setAuditStatus(2);
        saleMan.setLevel("美业导师");
        saleMan.setCreateTime(new Date());
        saleMan.setUpdateId(user.getId());
        saleMan.setUpdateTime(new Date());
        saleManService.save(saleMan);

        return user;
    }

    @Transactional
    @Override
    public Long addUserByPhone(String phone, Long parentId) {
        this.exit(phone);

        User user = new User();
        user.setPhone(phone);
        user.setPassword(PasswordUtils.getInitPassword());
        user.setType(2);
        user.setParentId(parentId);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insertSelective(user);

        return user.getId();
    }

    @Transactional
    @Override
    public void resetPassword(FindPasswordVo vo) {
        User user = this.getByUserAccount(vo.getUserPhone());
        if (user == null) {
            throw new RuntimeException("手机号码不存在.");
        }
        User update = new User();
        update.setId(user.getId());
        update.setPassword(PasswordUtils.getPassword(vo.getUserPassword()));
        update.setUpdateTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
    }


    @Transactional
    @Override
    public void delete(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User getByUserAccount(String userAccount) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("phone", userAccount);
        return userMapper.selectOneByExample(example);
    }

    @Override
    public User getByInviteCode(String inviteCode) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("inviteCode", inviteCode);
        return userMapper.selectOneByExample(example);
    }

    private void exit(String phone) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("phone", phone);
        User role = userMapper.selectOneByExample(example);
        if (role != null) {
            throw new RuntimeException("该用户手机号已经存在.");
        }
    }

    public String getInviteCode() {
        String inviteCode = InviteCodeGenerator.inviteCode();
        User user = this.getByInviteCode(inviteCode);
        if (user != null) {
            logger.info("重新获取 inviteCode=" + inviteCode);
            this.getInviteCode();
        }
        return inviteCode;
    }
}
