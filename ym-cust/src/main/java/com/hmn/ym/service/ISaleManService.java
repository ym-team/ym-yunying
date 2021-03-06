package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.SaleMan;
import com.hmn.ym.dao.entity.vo.RealNameAuthVo;
import com.hmn.ym.dao.entity.vo.SaleManVo;

import java.util.List;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
public interface ISaleManService extends BaseService<SaleMan> {
    /**
     * 保存
     *
     * @param vo
     */
    void save(SaleMan vo);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 获取业务员
     *
     * @param userId
     */
    SaleMan getByUserId(Long userId);

    /**
     * 获取我的团队
     *
     * @param userId
     */
    List<SaleManVo> getByParentId(Long userId);

    /**
     * 实名认证
     *
     * @param vo
     */
    void realNameAuth(RealNameAuthVo vo);
}




