package com.hmn.ym.common.enums;

public enum ServerCode {
    SUCCESS(2000, "成功"),
    AUTH_FAILED(-1, "认证失败"),
    SYSTEM_ERROR(-2, "系统异常"),
    UNKNOW_ERROR(-3, "未知异常"),
    PARAM_ERROR(-4, "参数异常"),
    BIZ_ERROR(-5, "业务异常"),
    UNSUPPORTED_ERROR(-6, "Unsupported"),
    NOT_FOUND(-7, "Not Found Record"),
    FAIL(-999, "失败"),

    OTHER_ERROR(-500, "其他");

    private Integer code;
    private String message;

    private ServerCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return code;
    }

    public String message() {
        return message;
    }
}
