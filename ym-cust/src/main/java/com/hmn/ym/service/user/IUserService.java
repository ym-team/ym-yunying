package com.hmn.ym.service.user;

import com.hmn.ym.dao.entities.po.User;
import com.hmn.ym.service.BaseService;

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
    void addUserByPhone(String phone);

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
