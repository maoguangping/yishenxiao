package com.mgp.dbproject.commons.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.mgp.dbproject.usermanager.beans.User;

public class ShiroUtils {
  public static Subject getSubject(){
	  return SecurityUtils.getSubject();
  }
  
  public static Session getSession(){
	  return getSubject().getSession();
  }
  
  public static User getUserEntity(){
	  return (User)getSubject().getPrincipal();
  }
  
  public static Long getUserId(){
	  return getUserEntity().getId();
  }
  
  public static void setAttribute(Object key, Object value){
	  getSession().setAttribute(key, value);
  }
  
  public static Object getAttribute(Object key){
	  return getSession().getAttribute(key);
  }
  
  public static boolean getLogin(){
	  return SecurityUtils.getSubject().getPrincipal() != null;
  }
  
  public static void logout(){
	  getSubject().logout();
  }
  
  public static void setSessionTimeOut(int time){
	  getSession().setTimeout(time);
  }
}
