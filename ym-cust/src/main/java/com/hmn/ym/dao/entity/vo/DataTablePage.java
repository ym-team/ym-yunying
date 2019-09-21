package com.hmn.ym.dao.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class DataTablePage<T> {
    /*
     * 必要。上面提到了，Datatables发送的draw是多少那么服务器就返回多少。
     */
    private int draw;

    /*
     * 必要。即没有过滤的记录数（数据库里总共记录数）
     */
    private int recordsTotal;

    /*
     * 必要。过滤后的记录数（如果有接收到前台的过滤条件，则返回的是过滤后的记录数）
     */
    private int recordsFiltered;

    /*
     * 必要。表中中需要显示的数据。
     */
    private List<T> data;


    public DataTablePage() {

    }

    public DataTablePage(int draw, int recordsTotal, List<T> data) {
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsTotal;
        this.data = data;
    }
}