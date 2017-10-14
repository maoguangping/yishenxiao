package com.mgp.dbproject.usermanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgp.dbproject.usermanager.dao.UserRelationRoleMapper;
import com.mgp.dbproject.usermanager.service.UserRelationRoleService;

@Service("userRelationRoleService")
public class UserRelationRoleServiceImpl implements UserRelationRoleService{

	@Autowired
	private UserRelationRoleMapper userRelationRoleMapper;

	@Override
	public Long getRoleIdByUserId(Long id) {
		return userRelationRoleMapper.getRoleIdByUserId(id);
	}
	
}
