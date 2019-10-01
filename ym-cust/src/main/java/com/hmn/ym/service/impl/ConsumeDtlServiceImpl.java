package com.hmn.ym.service.impl;

import com.hmn.ym.dao.entity.po.ConsumeDtl;
import com.hmn.ym.dao.mapper.ConsumeDtlMapper;
import com.hmn.ym.service.IConsumeDtlService;
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
            BeanUtils.copyProperties(vo, dtl);
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
}




