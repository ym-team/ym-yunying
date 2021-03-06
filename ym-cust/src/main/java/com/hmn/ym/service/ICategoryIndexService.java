package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.CategoryIndex;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
public interface ICategoryIndexService extends BaseService<CategoryIndex> {
    /**
     * 保存
     *
     * @param vo
     */
    void save(CategoryIndex vo);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);
}




