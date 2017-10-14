package com.mgp.dbproject.usermanager.service;

import java.util.List;

public interface RoleRelationMenuService {

	List<Long> getMenuIdByRoleId(Long roleId);

}
