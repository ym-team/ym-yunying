package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.User;

/**
 * @author xfz
 * @description 业务层
 * @since
 */
public interface IUserService extends BaseService<User> {
    /**
     * 保存
     *
     * @param vo
     */
    void save(User vo);

    /**
     * 保存
     *
     * @param phone
     */
    Long addUserByPhone(String phone);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 获取
     *
     * @param userAccount
     */
    User getByUserAccount(String userAccount);

    /**
     * 获取
     *
     * @param inviteCode
     */
    User getByInviteCode(String inviteCode);
}
