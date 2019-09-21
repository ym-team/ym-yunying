package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.TeamSum;
import com.hmn.ym.dao.mapper.TeamSumMapper;
import com.hmn.ym.service.ITeamSumService;
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
public class TeamSumServiceImpl extends BaseServiceImpl<TeamSum, TeamSumMapper> implements ITeamSumService {
    @Autowired
    private TeamSumMapper teamSumMapper;

    @Transactional
    @Override
    public void save(TeamSum vo) {
        if (vo.getId() != null) {
            TeamSum teamSum = new TeamSum();
            BeanUtils.copyProperties(vo, teamSum);

            teamSumMapper.updateByPrimaryKeySelective(teamSum);
        } else {

            TeamSum teamSum = new TeamSum();
            BeanUtils.copyProperties(vo, teamSum);

            teamSumMapper.insertSelective(teamSum);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        teamSumMapper.deleteByPrimaryKey(id);
    }
}




