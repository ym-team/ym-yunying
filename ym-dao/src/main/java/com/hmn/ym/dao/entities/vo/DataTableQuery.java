package com.hmn.ym.dao.entities.vo;

import lombok.Data;

@Data
public class DataTableQuery {

    /*------------------DT自动请求的参数(Sent parameters) begin--------------------*/
    /*
     * 绘制计数器。这个是用来确保Ajax从服务器返回的是对应的（Ajax是异步的，因此返回的顺序是不确定的）。 要求在服务器接收到此参数后再返回
     */
    private int draw; // 第几次请求
    /*
     * 第一条数据的起始位置，比如0代表第一条数据
     */
    private int start;// 起止位置
    /*
     * 告诉服务器每页显示的条数，这个数字会等于返回的 data集合的记录数，可能会大于因为服务器可能没有那么多数据。
     * 这个也可能是-1，代表需要返回全部数据(尽管这个和服务器处理的理念有点违背)
     */
    private int length; // 数据长度

    /*
     * 如果为 true代表全局搜索的值是作为正则表达式处理，为 false则不是。
     * 注意：通常在服务器模式下对于大数据不执行这样的正则表达式，但这都是自己决定的
     */
    private boolean is_search;

    /*
     * 告诉后台那些列是需要排序的。 i是一个数组索引，对应的是 columns配置的数组，从0开始
     */
    private int[] order;

    /*
     * 告诉后台列排序的方式， desc 降序 asc升序
     */
    private String order_dir;

    /*
     * columns 绑定的数据源，由 columns.dataOption 定义。
     */
    private String columns_data;

    /*
     * columns 的名字，由 columns.nameOption 定义。
     */
    private String columns_name;

    /*
     * 标记列是否能被搜索,为true代表可以，否则不可以，这个是由 columns.searchableOption 控制
     */
    private String columns_searchable;

    /*
     * 标记列是否能排序,为 true代表可以，否则不可以，这个是由 columns.orderableOption 控制
     */
    private boolean is_orderable;

    /*
     * 标记具体列的搜索条件
     */
    private String columns_search_value;

    /*
     * 特定列的搜索条件是否视为正则表达式， 如果为 true代表搜索的值是作为正则表达式处理，为 false则不是。
     * 注意：通常在服务器模式下对于大数据不执行这样的正则表达式，但这都是自己决定的
     */
    private boolean is_search_regex;

    /*------------------DT自动请求的参数(Sent parameters) end--------------------*/

    public DataTableQuery() {

    }

    public void setStart(int start) {
        this.start = (start / 10) + 1;
    }
}