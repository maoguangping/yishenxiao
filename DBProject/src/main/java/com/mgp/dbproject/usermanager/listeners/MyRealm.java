package com.mgp.dbproject.usermanager.listeners;  
  
import java.util.HashSet;  
import java.util.List;
import java.util.Set;  

import org.apache.shiro.authc.AuthenticationException;  
import org.apache.shiro.authc.AuthenticationInfo;  
import org.apache.shiro.authc.AuthenticationToken; 
import org.apache.shiro.authc.SimpleAuthenticationInfo;  
import org.apache.shiro.authc.UnknownAccountException;  
import org.apache.shiro.authz.AuthorizationInfo;  
import org.apache.shiro.authz.SimpleAuthorizationInfo;  
import org.apache.shiro.realm.AuthorizingRealm;  
import org.apache.shiro.subject.PrincipalCollection;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.beans.factory.annotation.Qualifier;

import com.mgp.dbproject.commons.utils.StringUtils;
import com.mgp.dbproject.usermanager.beans.Menu;
import com.mgp.dbproject.usermanager.beans.Role;
import com.mgp.dbproject.usermanager.beans.User;
import com.mgp.dbproject.usermanager.service.MenuService;
import com.mgp.dbproject.usermanager.service.RoleService;
import com.mgp.dbproject.usermanager.service.UserService;
  
public class MyRealm extends AuthorizingRealm{  
      
    @Autowired(required=false)@Qualifier("userService")  
    private UserService userService; 
    
    @Autowired(required=false)@Qualifier("roleService")
    private RoleService roleService;
    
    @Autowired(required=false)@Qualifier("roleService")
    private MenuService menuService;
  
    /** 
     * 授权操作 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
//      String username = (String) getAvailablePrincipal(principals);  
        String username = (String) principals.getPrimaryPrincipal();  
          
        Role role =  userService.getUserByUsername(username).getRole(); 
        //权限名的集合  
        Set<String> permsSet = new HashSet<String>(); 
        List<Menu> menuList=menuService.getMenuByRoleId(role.getId());
        for(Menu menu : menuList){
        	if(StringUtils.judgeBlank(menu.getMenuperms())){
  				continue;
  			}
        	permsSet.add(menu.getMenuperms());
        } 
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();        
        authorizationInfo.setStringPermissions(permsSet);          
        return authorizationInfo;  
    }  
  
    /** 
     * 身份验证操作 
     */  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(  
            AuthenticationToken token) throws AuthenticationException {  
          
        String username = (String) token.getPrincipal();  
        User user = userService.getUserByUsername(username);  
          
        if(user==null){  
            //木有找到用户  
        	
            throw new UnknownAccountException("没有找到该账号");  
        }  
        /* if(Boolean.TRUE.equals(user.getLocked())) {   
                throw new LockedAccountException(); //帐号锁定   
            } */  
          
        /** 
         * 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现   
         */  
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUseraccount(), user.getUserpassword(),getName());  
          
          
        return info;  
    }  
      
    @Override  
    public String getName() {  
        return getClass().getName();  
    }  
  
}  
