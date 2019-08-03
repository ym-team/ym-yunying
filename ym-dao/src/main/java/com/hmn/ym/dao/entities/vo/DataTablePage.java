package com.hmn.ym.dao.entities.vo;

import lombok.Data;

import java.util.List;

@Data
public class DataTablePage<T> {
    /*------------------服务器需要返回的数据(Returned data) begin--------------------*/

    /*
     * 必要。上面提到了，Datatables发送的draw是多少那么服务器就返回多少。
     * 这里注意，作者出于安全的考虑，强烈要求把这个转换为整形，即数字后再返回，而不是纯粹的接受然后返回，这是 为了防止跨站脚本（XSS）攻击。
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
     * 必要。表中中需要显示的数据。这是一个对象数组，也可以只是数组， 区别在于 纯数组前台就不需要用 columns绑定数据，会自动按照顺序去显示
     * ，而对象数组则需要使用 columns绑定数据才能正常显示。 注意这个 data的名称可以由 ajaxOption 的
     * ajax.dataSrcOption 控制
     */
    private List<T> data;

    /*
     * 可选。你可以定义一个错误来描述服务器出了问题后的友好提示
     */
    private String error;

    /*-------------可选参数-----------------*/

    /*
     * 自动绑定到 tr节点上
     */
    private String dt_rowId;

    /*
     * 自动把这个类名添加到 tr
     */
    private String dt_rowClass;

    /*
     * 使用 jQuery.data() 方法把数据绑定到row中，方便之后用来检索（比如加入一个点击事件）
     */
    private Object dt_rowData;

    /*
     * 自动绑定数据到 tr上，使用 jQuery.attr() 方法，对象的键用作属性，值用作属性的值。 注意这个 需要 Datatables
     * 1.10.5+的版本才支持
     */
    private Object dt_rowAttr;

    /*-------------可选参数-----------------*/
    /*------------------服务器需要返回的数据(Returned data) end--------------------*/

    public DataTablePage() {

    }

    public DataTablePage(int draw, int recordsTotal, List<T> data) {
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsTotal;
        this.data = data;
    }
}