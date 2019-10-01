package com.hmn.ym.dao.entity.vo;

import com.hmn.ym.dao.entity.BaseEntity;
import lombok.Data;


@Data
public class RealNameAuthVo extends BaseEntity {

    private Long saleManId;

    private String realName;

    private String cardNum;

    private String sfzzm;

    private String sfzfm;

    private String sfzsc;
}
