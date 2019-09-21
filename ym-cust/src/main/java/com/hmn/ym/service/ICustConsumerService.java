package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.CustConsumer;
import com.hmn.ym.dao.entity.vo.CustConsumerVo;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
public interface ICustConsumerService extends BaseService<CustConsumer> {
    /**
     * 保存
     *
     * @param vo
     */
    void save(CustConsumer vo);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);
}




