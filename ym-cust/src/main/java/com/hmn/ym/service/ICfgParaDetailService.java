package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.CfgParaDetail;

/**
 * @author
 * @date [Thu Mar 07 10:38:50 CST 2019]
 * @desc 本类为cfg_para_detail的Service接口
 */

public interface ICfgParaDetailService extends BaseService<CfgParaDetail> {

    /**
     * 系统启动加载配置类信息
     */
    void getAllCfgParaToCach();

}