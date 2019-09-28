package com.hmn.ym.service;

import com.hmn.ym.dao.entity.po.User;
import com.hmn.ym.dao.entity.vo.FindPasswordVo;
import com.hmn.ym.dao.entity.vo.RegisterVo;

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
    User register(RegisterVo vo);

    /**
     * 保存
     *
     * @param phone
     * @param parentId
     */
    Long addUserByPhone(String phone, Long parentId);

    /**
     * 重置密码
     *
     * @param vo
     */
    void resetPassword(FindPasswordVo vo);

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
