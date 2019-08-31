package com.hmn.ym.dao.entities.vo;

import lombok.Data;

/**
 * 公共查询请求对象
 *
 * @author xufz
 */
@Data
public class BaseQueryVo {
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

    public BaseQueryVo() {

    }

    public void setStart(int start) {
        this.start = (start / 10) + 1;
    }
}
