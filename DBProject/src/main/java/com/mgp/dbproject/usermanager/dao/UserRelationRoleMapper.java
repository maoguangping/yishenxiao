package com.mgp.dbproject.usermanager.dao;

import com.mgp.dbproject.usermanager.beans.UserRelationRole;

public interface UserRelationRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRelationRole record);

    int insertSelective(UserRelationRole record);

    UserRelationRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRelationRole record);

    int updateByPrimaryKey(UserRelationRole record);

	Long getRoleIdByUserId(Long id);
}