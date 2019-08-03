package com.hmn.ym.common.model;

import lombok.Data;

/**
 * 查询公共请求
 *
 * @author xfz
 */
@Data
public class BaseQueryReq extends BaseReq {
    private static final long serialVersionUID = 1L;
    /**
     * 当前页数
     */
    private Integer pageNum = 0;
    /**
     * 每页显示数量
     */
    private Integer pageSize = 10;

    public Integer getPageSize() {
        return pageSize > 1000 ? 1000 : pageSize;
    }
}
