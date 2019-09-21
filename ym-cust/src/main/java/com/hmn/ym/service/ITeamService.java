package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.Team;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
public interface ITeamService extends BaseService<Team> {
    /**
     * 保存
     *
     * @param vo
     */
    void save(Team vo);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);
}




