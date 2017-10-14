package com.mgp.dbproject.usermanager.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgp.dbproject.usermanager.beans.Role;
import com.mgp.dbproject.usermanager.dao.RoleMapper;
import com.mgp.dbproject.usermanager.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper rolemapper;
	
	@Override
	public Role findRoleById(Long id) {
		rolemapper.selectByPrimaryKey(id);
		return null;
	}

}
