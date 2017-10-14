package com.mgp.dbproject.usermanager.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.naming.AuthenticationException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.mgp.dbproject.commons.utils.ReturnInfo;
import com.mgp.dbproject.commons.utils.ShiroUtils;
import com.mgp.dbproject.commons.utils.StringUtils;
import com.mgp.dbproject.usermanager.beans.Items;
import com.mgp.dbproject.usermanager.beans.Menu;
import com.mgp.dbproject.usermanager.beans.MenuItem;
import com.mgp.dbproject.usermanager.beans.MenuItems;
import com.mgp.dbproject.usermanager.beans.User;
import com.mgp.dbproject.usermanager.service.MenuService;
import com.mgp.dbproject.usermanager.service.RoleService;
import com.mgp.dbproject.usermanager.service.UserService;


/**
 * 登录相关
 * 
 * @author mgp
 * @date 2017年7月19日 下午
 */
@Controller
public class SysLoginController{
	@Autowired
	private Producer captchaProducer;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MenuService menuService;

	@RequestMapping("/captcha")
	public void getCheckCode(HttpServletRequest request, HttpServletResponse response) throws IOException {   
		// Set to expire far in the past.  
        response.setDateHeader("Expires", 0);  
        // Set standard HTTP/1.1 no-cache headers.  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).  
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
        // Set standard HTTP/1.0 no-cache header.  
        response.setHeader("Pragma", "no-cache");  
        // return a jpeg  
        response.setContentType("image/jpeg"); 
		String codeStr = captchaProducer.createText();
	    request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, codeStr);
	    BufferedImage bi = captchaProducer.createImage(codeStr);
	    ServletOutputStream out = response.getOutputStream();
	    ImageIO.write(bi, "jpg", out);
	    out.flush();
	    out.close();
	}
	
	@RequestMapping("/checklogin")
	public @ResponseBody ReturnInfo loginSystem(HttpServletRequest request, HttpServletResponse response, String loginusername, String loginpassword, String logincaptcha){
		//判断参数
		if(StringUtils.judgeBlank(loginusername) 
				|| StringUtils.judgeBlank(loginpassword) 
				|| StringUtils.judgeBlank(logincaptcha)){
			return ReturnInfo.error("参数错误！");
		}
		//检查验证码
		String sessionCode = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);    
		if( !logincaptcha.equals(sessionCode) ){
			return ReturnInfo.error("验证码错误！");
		}
		Map<Object, Object> mapInfo = new HashMap<Object, Object>();
		//登录交给shiro		
		try{
	      Subject subject = ShiroUtils.getSubject();
		  UsernamePasswordToken token = new UsernamePasswordToken(loginusername, loginpassword);	
		  token.setRememberMe(true);
		  subject.login(token);
		}catch (UnknownAccountException e) {
			return ReturnInfo.error(e.getMessage());
		}catch (IncorrectCredentialsException e) {
			return ReturnInfo.error(e.getMessage());
		}catch (LockedAccountException e) {
			return ReturnInfo.error(e.getMessage());
		}
		//准备session数据
		User user = userService.getUserByLogin(loginusername, loginpassword);//账号唯一
		List<Menu> listMenu = menuService.getMenuByUserId(user.getId());
		//后台处理菜单格式
		List<MenuItems> menuItemslist = getMenuItems(listMenu);
		JSONArray jsonArray = JSONArray.fromObject(menuItemslist);
		String str = jsonArray.toString().replaceAll("\"menuItem\"","menu");
		str = str.replaceAll("\"id\"","id");
		str = str.replaceAll("\"items\"","items");
		str = str.replaceAll("\"href\"","href");
		str = str.replaceAll("\"text\"","text");
		System.out.println("12345");
		System.out.println(str);
		mapInfo.put("user", user);
		mapInfo.put("menu", menuItemslist);
		Session session = ShiroUtils.getSession();
		session.setAttribute("userAccount", user.getUseraccount());
		session.setAttribute(user.getUseraccount(), user);
		//session.setAttribute("menu", listMenu);
		return ReturnInfo.info(200, mapInfo);
	}
	
	@RequestMapping("/logout")
	public @ResponseBody ReturnInfo logout(){
		ShiroUtils.logout();
		return ReturnInfo.ok("success");
	}
	
	public List<MenuItems> getMenuItems(List<Menu> listMenu){
		MenuItems menuItems = new MenuItems();
		List<MenuItem> menuItemlist = new ArrayList<MenuItem>();
		List<MenuItems> menuItemslist = new ArrayList<MenuItems>();
		
		List<Menu> dirlist = new ArrayList<Menu>();
		List<Menu> dirsyslist = new ArrayList<Menu>();
		List<Menu> menulist = new ArrayList<Menu>();
		for(int i=0;i<listMenu.size();i++){
		  if(listMenu.get(i).getMenuparentid()==0){//判断目录
			if(listMenu.get(i).getId()==1){//限制系统管理目录id必须为1
				dirsyslist.add(listMenu.get(i));
			}else{
				dirlist.add(listMenu.get(i));
			}
		  }else{
			  menulist.add(listMenu.get(i));
		  }
		}
		if(dirsyslist.size()==0){//没有系统管理的用户
			menuItemlist = getlist(menulist, dirlist);
			menuItems.setId("1");
			menuItems.setMenuItem(menuItemlist);
			menuItemslist.add(menuItems);
		}else{//管理员
		  //设置系统的
			menuItemlist = getlist(menulist, dirsyslist);
			menuItems.setId("1");
			menuItems.setMenuItem(menuItemlist);
			menuItemslist.add(menuItems);
			
		  //设置业务的
			menuItems = new MenuItems();
			menuItemlist = getlist(menulist, dirlist);
			menuItems.setId("2");
			menuItems.setMenuItem(menuItemlist);
			menuItemslist.add(menuItems);
		}
		return menuItemslist;
	}
	
	public List<MenuItem> getlist(List<Menu> menulist, List<Menu> dirlist){
		List<MenuItem> menuItemlisttemp = new ArrayList<MenuItem>();
		List<Items> itemslisttemp = new ArrayList<Items>();
			
		for(int i=0;i<dirlist.size();i++){
			MenuItem menuItem = new MenuItem();	
			menuItem.setText(dirlist.get(i).getMenuname());				
			List<Menu> menus=getItems(menulist, dirlist.get(i).getId());//得到目录页面
			for(int j=0;j<menus.size();j++){		
				  Items items = new Items();
				  items.setId(menus.get(j).getId().toString());
				  items.setText(menus.get(j).getMenuname());
				  items.setHref(menus.get(j).getMenuurl());
				  itemslisttemp.add(items);
			}
			menuItem.setItems(itemslisttemp);
			menuItemlisttemp.add(menuItem);
		}	
		return menuItemlisttemp;
	}
	
	public List<Menu> getItems(List<Menu> menulist, Long menuItemId){
		List<Menu> rmenulist = new ArrayList<Menu>();
		for(int i=0;i<menulist.size();i++){
			if(menulist.get(i).getMenuparentid()==menuItemId){
				rmenulist.add(menulist.get(i));
			}
		}
		
		return rmenulist;
	}
}
