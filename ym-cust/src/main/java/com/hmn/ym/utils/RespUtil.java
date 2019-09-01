package com.hmn.ym.utils;

import com.hmn.ym.common.model.BaseResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 响应
 */
public final class RespUtil {
    //成功响应状态码
    private static final int SUCCESS_CODE = 200;
    private static final int FAIL_CODE = 999;

    public static ResponseEntity<BaseResp> success() {
        return new ResponseEntity<BaseResp>(new BaseResp(SUCCESS_CODE, Boolean.TRUE, null), HttpStatus.OK);
    }

    public static ResponseEntity<BaseResp> success(final Object data) {
        return new ResponseEntity<BaseResp>(new BaseResp(SUCCESS_CODE, data, null), HttpStatus.OK);
    }

    public static ResponseEntity<BaseResp> fail(final Object data) {
        return new ResponseEntity<BaseResp>(new BaseResp(FAIL_CODE, data, null), HttpStatus.OK);
    }

    public static ResponseEntity<BaseResp> failMsg(final String msg) {
        return new ResponseEntity<BaseResp>(new BaseResp(FAIL_CODE, null, msg), HttpStatus.OK);
    }
}
