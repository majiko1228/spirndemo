package cn.ndky.config;

import cn.ndky.common.ShiroUser;

import cn.ndky.mapper.UserMapper;
import cn.ndky.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    /**
     * 授权
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SimpleAuthorizationInfo info = null;
        ShiroUser shiroUser = (ShiroUser)principal.getPrimaryPrincipal();

        if(shiroUser != null){
            info = new SimpleAuthorizationInfo();
            List<String> roles = shiroUser.getRoles();
            info.addRoles(roles);
        }

        return info;
    }

    /**
     * 登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo info = null;
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;

        String userId = upToken.getUsername();
        User user = userMapper.getUserByUserId(userId);
        if(user!=null){

            ShiroUser shiroUser = new ShiroUser();
            shiroUser.setUser(user);
            shiroUser.setRoles(userMapper.getRoleIdsByUserId(userId));
            shiroUser.setRoleDesc(userMapper.getRoleNamesByUserId(userId));

            info = new SimpleAuthenticationInfo(shiroUser,user.getPassword(), ByteSource.Util.bytes(user.getUserId()),getName());
        }

        return info;
    }
}
