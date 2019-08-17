package com.hmn.ym.manager.service.hospital;


import com.hmn.ym.dao.entities.po.hospital.Hospital;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.hospital.HospitalVo;
import com.hmn.ym.manager.service.BaseService;

public interface IHospitalService extends BaseService<Hospital> {

    /**
     * 获取医院分页
     *
     * @param vo
     * @return
     */
    DataTablePage<Hospital> page(BaseQueryVo vo);

    /**
     * 保存医院
     *
     * @param vo
     */
    void save(HospitalVo vo);


    /**
     * 删除医院
     *
     * @param id
     */
    void delete(Integer id);
}
