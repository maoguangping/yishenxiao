package com.mgp.dbproject.usermanager.dao;

import com.mgp.dbproject.usermanager.beans.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User getUserByLogin(User user);

	User getUserByUsername(String username);
}