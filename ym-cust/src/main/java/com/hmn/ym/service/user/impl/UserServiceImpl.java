package com.hmn.ym.service.user.impl;

import com.hmn.ym.dao.entities.po.User;
import com.hmn.ym.dao.mapper.UserMapper;
import com.hmn.ym.service.BaseServiceImpl;
import com.hmn.ym.service.user.IUserService;
import com.hmn.ym.utils.Const;
import com.hmn.ym.utils.des.DesEncrypt;
import com.hmn.ym.utils.des.MD5Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements IUserService {
    private static final DesEncrypt desEncrpt = new DesEncrypt(Const.DES_PUBLIC_ENCRYPT_KEY);
    private static final DesEncrypt aesEncrypt = new DesEncrypt(Const.DES_PRIVATE_ENCRYPT_KEY);

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public void save(User vo) {
        if (vo.getId() != null) {
            User exit = userMapper.selectByPrimaryKey(vo.getId());
            if (!exit.getPhone().equals(vo.getPhone())) {
                this.exit(vo.getPhone());
            }
            User user = new User();
            BeanUtils.copyProperties(vo, user);

            userMapper.updateByPrimaryKeySelective(user);
        } else {
            this.exit(vo.getPhone());

            User user = new User();
            BeanUtils.copyProperties(vo, user);
            user.setPassword(MD5Utils.stringToMD5(aesEncrypt.encrypt(desEncrpt.decrypt(vo.getPassword()))));
            user.setCreateTime(new Date());

            userMapper.insertSelective(user);
        }
    }

    @Transactional
    @Override
    public Long addUserByPhone(String phone) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword(MD5Utils.stringToMD5(aesEncrypt.encrypt(desEncrpt.decrypt("123456"))));
        user.setType(2);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insertSelective(user);

        return user.getId();
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        //删除角色
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
            throw new RuntimeException("该用户已经存在.");
        }
    }
}
