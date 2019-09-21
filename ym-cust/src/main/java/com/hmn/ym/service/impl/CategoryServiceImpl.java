package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.Category;
import com.hmn.ym.dao.mapper.CategoryMapper;
import com.hmn.ym.service.ICategoryService;
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
public class CategoryServiceImpl extends BaseServiceImpl<Category, CategoryMapper> implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Transactional
    @Override
    public void save(Category vo) {
        if (vo.getId() != null) {
            Category category = new Category();
            BeanUtils.copyProperties(vo, category);

            categoryMapper.updateByPrimaryKeySelective(category);
        } else {

            Category category = new Category();
            BeanUtils.copyProperties(vo, category);

            categoryMapper.insertSelective(category);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        categoryMapper.deleteByPrimaryKey(id);
    }
}




