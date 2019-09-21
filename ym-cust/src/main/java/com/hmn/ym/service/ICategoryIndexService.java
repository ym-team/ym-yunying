package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.CategoryIndex;

/**
* @description 业务层
* @author  xfz
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




