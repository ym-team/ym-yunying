package com.hmn.ym.manager.common.shiro;

import com.hmn.ym.dao.entities.po.system.Permission;
import com.hmn.ym.dao.entities.po.system.User;
import com.hmn.ym.dao.entities.vo.ShiroUser;
import com.hmn.ym.dao.entities.vo.system.RoleVo;
import com.hmn.ym.manager.service.system.IUserService;
import com.hmn.ym.manager.utils.Encodes;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

public class ShiroDbRealm extends AuthorizingRealm {
    private static final String SALT = "7efbd59d9741d34f";
    @Autowired
    private IUserService userService;

    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("SHA-1");
        matcher.setHashIterations(1024);
        setCredentialsMatcher(matcher);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = userService.getByUserName(token.getUsername());
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        if (!user.getStatus()) {
            throw new RuntimeException("用户已离职");
        }
        byte[] salt = Encodes.decodeHex(SALT);
        ShiroUser shiroUser = new ShiroUser(user.getId(), user.getName(), user.getName());
        return new SimpleAuthenticationInfo(shiroUser, user.getPassword(), ByteSource.Util.bytes(salt), this.getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        List<RoleVo> roleList = shiroUser.getRoleList();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (RoleVo role : roleList) {
            info.addRole(role.getName());
            for (Permission p : role.getPermissions()) {
                if (StringUtils.isNotBlank(p.getCode())) {
                    info.addStringPermission(p.getCode());
                }
            }
        }
        return info;
    }
}
