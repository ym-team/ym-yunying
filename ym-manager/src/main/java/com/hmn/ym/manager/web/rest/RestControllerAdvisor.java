package com.hmn.ym.manager.web.rest;

import com.hmn.ym.common.exception.BizException;
import com.hmn.ym.common.model.BaseResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常统一处理，并转友好提示
 */
@RestControllerAdvice(annotations = RestController.class)
public class RestControllerAdvisor {
    private final static Logger log = LoggerFactory.getLogger(RestControllerAdvisor.class);

    @ExceptionHandler
    public ResponseEntity<BaseResp> globalExceptions(HttpServletRequest request, Exception e) {
        log.error("请求出现异常：" + e.getMessage(), e);

        BaseResp resp = new BaseResp();
        if (e instanceof BizException) {
            BizException be = (BizException) e;
            resp.setCode(be.getCode());
            resp.setMsg(be.getMessage());
        } else {
            resp.setCode(500);
            resp.setMsg("系统繁忙");
        }
        return new ResponseEntity<BaseResp>(resp, HttpStatus.OK);
    }
}

