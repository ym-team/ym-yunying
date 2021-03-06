package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.ConsumeDtl;
import com.hmn.ym.dao.mapper.ConsumeDtlMapper;
import com.hmn.ym.service.IConsumeDtlService;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
@Service
public class ConsumeDtlServiceImpl extends BaseServiceImpl<ConsumeDtl, ConsumeDtlMapper> implements IConsumeDtlService {
    @Autowired
    private ConsumeDtlMapper consumeDtlMapper;
    
    
    
	@Override
	public Double myTeamMoney(List<Long> listUserId2) {
		return this.consumeDtlMapper.myTeamMoney(listUserId2);
	}
    
    @Override
    public Double queryMyMoneyByThisMonth(long userId) {
            return consumeDtlMapper.queryMyMoneyByThisMonth(userId);
    }

    
    

    @Transactional
    @Override
    public void save(ConsumeDtl vo) {
        ConsumeDtl dtl = this.getByAppointmentId(vo.getAppointmentId());
        if (dtl != null) {
            ConsumeDtl update = new ConsumeDtl();
            BeanUtils.copyProperties(vo, update);
            update.setUpdateTime(new Date());

            consumeDtlMapper.updateByPrimaryKeySelective(update);
        } else {
            ConsumeDtl insert = new ConsumeDtl();
            BeanUtils.copyProperties(vo, insert);
            insert.setAuditStatus(1);
            insert.setStatus(1);
            insert.setCreateId(vo.getBussinessUserId());
            insert.setCreateTime(new Date());
            insert.setUpdateId(vo.getBussinessUserId());
            insert.setUpdateTime(new Date());

            consumeDtlMapper.insertSelective(insert);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        consumeDtlMapper.deleteByPrimaryKey(id);
    }





    @Override
    public ConsumeDtl getByAppointmentId(Long appointmentId) {
        Example example = new Example(ConsumeDtl.class);
        example.createCriteria().andEqualTo("appointmentId", appointmentId);
        return consumeDtlMapper.selectOneByExample(example);
    }

	@Override
	public Double queryMyOrderByThisMonth(Long userId) {
		return consumeDtlMapper.queryMyOrderByThisMonth(userId);
	}

	@Override
	public Double myTeamOrder(List<Long> listUserId) {
		return this.consumeDtlMapper.myTeamOrder(listUserId);
	}

	@Override
	public Double myAddShop(Long userId) {
		return this.consumeDtlMapper.myAddShop(userId);
	}

	@Override
	public Double myTeamAddShop(List<Long> listUserId2) {
		return this.consumeDtlMapper.myTeamAddShop(listUserId2);
	}

	@Override
	public Double myAppointMentCustmer(Long userId) {
		return this.consumeDtlMapper.myAppointMentCustmer(userId);
	}

	@Override
	public Double myTeamAppointMentCustmer(List<Long> listUserId2) {
		return this.consumeDtlMapper.myTeamAppointMentCustmer(listUserId2);
	}

	@Override
	public List<ConsumeDtl> myMonesyList(Long userId) {
		return this.consumeDtlMapper.myMonesyList(userId);
	}
}




