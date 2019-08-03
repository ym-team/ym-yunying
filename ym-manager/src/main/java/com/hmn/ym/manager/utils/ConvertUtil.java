package com.hmn.ym.manager.utils;

import com.google.common.collect.Sets;
import com.hmn.ym.dao.entities.vo.system.RoleVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Set;

public final class ConvertUtil {
    private static final String REGEX = ",";

    public static String convertUserRoleNames(final List<RoleVo> userRoles) {
        if (CollectionUtils.isEmpty(userRoles)) {
            return StringUtils.EMPTY;
        }
        Set<String> roleNames = Sets.newHashSet();
        for (RoleVo role : userRoles) {
            if (role == null) {
                continue;
            }
            roleNames.add(role.getDescription());
        }
        return StringUtils.join(roleNames, REGEX);
    }

    public static String convertUserRoleIds(final List<RoleVo> userRoles) {
        if (CollectionUtils.isEmpty(userRoles)) {
            return StringUtils.EMPTY;
        }
        Set<Integer> roleIds = Sets.newHashSet();
        for (RoleVo role : userRoles) {
            if (role == null) {
                continue;
            }
            roleIds.add(role.getId());
        }
        return StringUtils.join(roleIds, REGEX);
    }
}




