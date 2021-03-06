package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.Category;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
public interface ICategoryService extends BaseService<Category> {
    /**
     * 保存
     *
     * @param vo
     */
    void save(Category vo);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);
}




