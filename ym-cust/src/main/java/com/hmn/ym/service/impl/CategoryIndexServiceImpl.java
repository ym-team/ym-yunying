package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.CategoryIndex;
import com.hmn.ym.dao.mapper.CategoryIndexMapper;
import com.hmn.ym.service.ICategoryIndexService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
@Service
public class CategoryIndexServiceImpl extends BaseServiceImpl<CategoryIndex, CategoryIndexMapper> implements ICategoryIndexService {
    @Autowired
    private CategoryIndexMapper categoryIndexMapper;

    @Transactional
    @Override
    public void save(CategoryIndex vo) {
        if (vo.getId() != null) {
            CategoryIndex categoryIndex = new CategoryIndex();
            BeanUtils.copyProperties(vo, categoryIndex);

            categoryIndexMapper.updateByPrimaryKeySelective(categoryIndex);
        } else {

            CategoryIndex categoryIndex = new CategoryIndex();
            BeanUtils.copyProperties(vo, categoryIndex);

            categoryIndexMapper.insertSelective(categoryIndex);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        categoryIndexMapper.deleteByPrimaryKey(id);
    }
}




