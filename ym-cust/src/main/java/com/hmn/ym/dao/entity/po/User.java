package com.hmn.ym.dao.entity.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "t_user")
public class User {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private Integer type;

    /**
     * 用户状态( 1：有效（默认）  2：失效 )
     */
    private Integer status;

    /**
     * 邀请码
     */
    @Column(name = "invite_code")
    private String inviteCode;

    /**
     * 邀请用户Id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建者Id
     */
    @Column(name = "update_id")
    private Long updateId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;
}