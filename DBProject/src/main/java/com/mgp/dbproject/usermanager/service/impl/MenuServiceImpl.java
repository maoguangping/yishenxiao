package com.mgp.dbproject.usermanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgp.dbproject.usermanager.beans.Menu;
import com.mgp.dbproject.usermanager.dao.MenuMapper;
import com.mgp.dbproject.usermanager.service.MenuService;
import com.mgp.dbproject.usermanager.service.RoleRelationMenuService;
import com.mgp.dbproject.usermanager.service.UserRelationRoleService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
   
	@Autowired
	private RoleRelationMenuService roleRelationMenuService;
	
	@Autowired
	private UserRelationRoleService userRelationRoleService;
	
	@Autowired
	private MenuMapper menumapper;
	
	@Override
	public int insertMenuService(Menu menu) {
		return menumapper.insert(menu);
	}

	@Override
	public List<Menu> getMenuByUserId(Long id) {
		
		//通过用户查找角色，通过角色查找菜单
		Long roleId = userRelationRoleService.getRoleIdByUserId(id);
		return getMenuByRoleId(roleId);
	}

	@Override
	public List<Menu> getMenuByRoleId(Long id) {
		List<Menu> listMenu = new ArrayList<Menu>();
		List<Long> listMenuId = roleRelationMenuService.getMenuIdByRoleId(id);
		for(Long menuId : listMenuId){
			listMenu.add(menumapper.selectByPrimaryKey(menuId));
		}
		return listMenu;
	}

}
