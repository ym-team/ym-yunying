package com.hmn.ym.common.exception;

/**
 * 自定义业务异常类
 *
 * @author xfz
 */
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int code;

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
        this.code = -1;
    }

    public BizException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 避免获取方法栈快照信息
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public int getCode() {
        return this.code;
    }
}
