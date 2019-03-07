package com.qyg.cmfz.utils;

import com.qyg.cmfz.dao.ManagerDao;
import com.qyg.cmfz.entity.Manager;
import com.qyg.cmfz.entity.Permission;
import com.qyg.cmfz.entity.Role;
import com.qyg.cmfz.service.ManagerService;
import com.qyg.cmfz.service.PermissionService;
import com.qyg.cmfz.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/11  21:41
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ManagerService managerService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("--------------------============");
        String  username = (String) principalCollection.getPrimaryPrincipal();
        if(username!=null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            List<Role> roles = roleService.queryAllByName(username);
            System.out.println(roles);
            for (Role role : roles) {
                info.addRole(role.getRoleTag());
            }
            List<Permission> permissions = permissionService.queryAll(username);
            for (Permission permission : permissions) {
                info.addStringPermission(permission.getPermissionTag());
            }
            return info;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("**************");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String username = token.getUsername();

        Manager manager = managerService.queryUserByName(username);
        if(manager!=null){
            return new SimpleAuthenticationInfo(manager.getMgrName(),manager.getMgrPwd(),ByteSource.Util.bytes(manager.getSalt()),UUID.randomUUID().toString().replace("-",""));
        }
        return null;
    }
}
