package com.mgp.dbproject.usermanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgp.dbproject.usermanager.dao.RoleRelationMenuMapper;
import com.mgp.dbproject.usermanager.service.RoleRelationMenuService;


@Service("roleRelationMenuService")
public class RoleRelationMenuServiceImpl implements RoleRelationMenuService {

	@Autowired
	private RoleRelationMenuMapper roleRelationMenuMapper;
	
	@Override
	public List<Long> getMenuIdByRoleId(Long roleId) {
		return roleRelationMenuMapper.getMenuIdByRoleId(roleId);
	}

}
