package com.hmn.ym.common.model;

import lombok.Data;

import java.util.List;

/**
 * 公共响应
 *
 * @author xfz
 */
@Data
public class BaseQueryResp<T> extends BaseResp {
    private static final long serialVersionUID = 1L;

    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页显示数量
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 总记录数
     */
    private long totalCount;
    /**
     * 返回数据集
     */
    private List<T> results;
}
