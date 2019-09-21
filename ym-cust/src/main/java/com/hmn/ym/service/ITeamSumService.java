package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.TeamSum;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
public interface ITeamSumService extends BaseService<TeamSum> {
    /**
     * 保存
     *
     * @param vo
     */
    void save(TeamSum vo);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);
}




