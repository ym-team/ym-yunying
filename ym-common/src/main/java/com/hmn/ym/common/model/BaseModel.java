package com.hmn.ym.common.model;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * 抽象实体类
 *
 * @author xufz
 */
@Data
public abstract class BaseModel implements Model {
    private static final long serialVersionUID = 1L;

    @Override
    public String toJson() {
        return JSON.toJSONString(this);
    }

}
