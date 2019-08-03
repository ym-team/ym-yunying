package com.hmn.ym.common.model;

import lombok.Data;

/**
 * 公共响应
 *
 * @author xufz
 */
@Data
public class BaseResp extends BaseModel {
    private static final long serialVersionUID = 1L;
    // 响应状态
    private int code;

    // 响应信息
    private String msg;

    // 响应数据
    private Object data;

    public BaseResp() {

    }

    public BaseResp(Object data) {
        this.data = data;
    }

    public BaseResp(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
