package com.hmn.ym.dao.entities.vo;

import lombok.Data;

/**
 * 公共查询请求对象
 *
 * @author xufz
 */
@Data
public class BaseQueryVo extends DataTableQuery {
    /**
     * 当前页数
     */
    private Integer pageNum = 0;
    /**
     * 每页显示数量
     */
    private Integer numPerPage = 10;
}
