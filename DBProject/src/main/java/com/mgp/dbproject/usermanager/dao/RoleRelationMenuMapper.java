package com.mgp.dbproject.usermanager.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mgp.dbproject.usermanager.beans.RoleRelationMenu;

@Service("roleRelationMenu")
public interface RoleRelationMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleRelationMenu record);

    int insertSelective(RoleRelationMenu record);

    RoleRelationMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleRelationMenu record);

    int updateByPrimaryKey(RoleRelationMenu record);

	List<Long> getMenuIdByRoleId(Long roleId);
}