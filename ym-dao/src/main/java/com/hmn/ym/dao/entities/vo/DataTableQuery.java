package com.hmn.ym.dao.entities.vo;

import lombok.Data;

@Data
public class DataTableQuery {

    /*
     * 第几次请求
     */
    private int draw;
    /*
     *  起止位置
     */
    private int start;
    /*
     * 数据长度
     */
    private int length;

    public DataTableQuery() {

    }

    public void setStart(int start) {
        this.start = (start / 10) + 1;
    }
}