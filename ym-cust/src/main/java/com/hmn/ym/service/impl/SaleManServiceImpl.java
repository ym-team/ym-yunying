package com.hmn.ym.service.impl;

import com.google.common.collect.Lists;
import com.hmn.ym.dao.entity.po.ConsumeDtl;
import com.hmn.ym.dao.entity.po.SaleMan;
import com.hmn.ym.dao.entity.po.User;
import com.hmn.ym.dao.entity.vo.SaleManVo;
import com.hmn.ym.dao.mapper.ConsumeDtlMapper;
import com.hmn.ym.dao.mapper.SaleManMapper;
import com.hmn.ym.dao.mapper.UserMapper;
import com.hmn.ym.service.ISaleManService;
import com.xiaoleilu.hutool.util.CollectionUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
@Service
public class SaleManServiceImpl extends BaseServiceImpl<SaleMan, SaleManMapper> implements ISaleManService {
    @Autowired
    private SaleManMapper saleManMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ConsumeDtlMapper consumeDtlMapper;

    @Transactional
    @Override
    public void save(SaleMan vo) {
        if (vo.getId() != null) {
            SaleMan saleMan = new SaleMan();
            BeanUtils.copyProperties(vo, saleMan);

            saleManMapper.updateByPrimaryKeySelective(saleMan);
        } else {
            SaleMan saleMan = new SaleMan();
            BeanUtils.copyProperties(vo, saleMan);

            saleManMapper.insertSelective(saleMan);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        saleManMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SaleMan getByUserId(Long userId) {
        Example example = new Example(SaleMan.class);
        example.createCriteria().andEqualTo("userId", userId);
        return saleManMapper.selectOneByExample(example);
    }


    @Override
    public List<SaleManVo> getByParentId(Long userId) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("parentId", userId);
        List<User> userList = userMapper.selectByExample(example);
        if (CollectionUtil.isEmpty(userList)) {
            return Lists.newArrayList();
        }
        example = new Example(SaleMan.class);
        example.createCriteria().andIn("userId", userList.stream().map(User::getId).collect(Collectors.toList()));
        List<SaleMan> saleManList = saleManMapper.selectByExample(example);

        List<SaleManVo> result = Lists.newArrayList();
        for (SaleMan sm : saleManList) {
            SaleManVo vo = new SaleManVo();
            BeanUtils.copyProperties(sm, vo);

            example = new Example(ConsumeDtl.class);
            example.createCriteria().andEqualTo("bussinessUserId", sm.getUserId());
            int total = consumeDtlMapper.selectCountByExample(example);
            vo.setAchievement(total);

            result.add(vo);
        }
        return result;
    }
}




