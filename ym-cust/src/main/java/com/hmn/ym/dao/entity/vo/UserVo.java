package com.hmn.ym.dao.entity.vo;

import com.hmn.ym.dao.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author xfz
 * @since 2018-05-28
 */
@Data
public class UserVo extends BaseEntity {
    /**
     * 手机号码
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型( 1：业务员  2：店家 3：消费者 )
     */
    private Boolean type;

    /**
     * 用户状态( 1：有效  2：失效 )
     */
    private Boolean status;

    /**
     * 邀请码
     */
    private String inviteCode;

    /**
     * 邀请用户Id
     */
    private Long parentId;
}
