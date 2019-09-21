package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.Team;
import com.hmn.ym.dao.mapper.TeamMapper;
import com.hmn.ym.service.ITeamService;
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
public class TeamServiceImpl extends BaseServiceImpl<Team, TeamMapper> implements ITeamService {
    @Autowired
    private TeamMapper teamMapper;

    @Transactional
    @Override
    public void save(Team vo) {
        if (vo.getId() != null) {
            Team team = new Team();
            BeanUtils.copyProperties(vo, team);

            teamMapper.updateByPrimaryKeySelective(team);
        } else {

            Team team = new Team();
            BeanUtils.copyProperties(vo, team);

            teamMapper.insertSelective(team);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        teamMapper.deleteByPrimaryKey(id);
    }
}




