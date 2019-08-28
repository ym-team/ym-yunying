package com.hmn.ym.manager.service.hospital;

import com.hmn.ym.dao.entities.po.Doctor;
import com.hmn.ym.dao.entities.vo.BaseQueryVo;
import com.hmn.ym.dao.entities.vo.DataTablePage;
import com.hmn.ym.dao.entities.vo.hospital.DoctorVo;
import com.hmn.ym.manager.service.BaseService;

public interface IDoctorService extends BaseService<Doctor> {

    /**
     * 获取医生分页
     *
     * @param vo
     * @return
     */
    DataTablePage<DoctorVo> page(BaseQueryVo vo);

    /**
     * 保存医生
     *
     * @param vo
     */
    void save(DoctorVo vo);


    /**
     * 删除医生
     *
     * @param id
     */
    void delete(Integer id);
}
