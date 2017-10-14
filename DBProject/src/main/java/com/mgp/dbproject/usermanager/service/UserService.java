package com.mgp.dbproject.usermanager.service;

import com.mgp.dbproject.usermanager.beans.User;

public interface UserService {

	public void removeUser();
    /*
     * 这个方法获取的数据有密码，限登录使用
     * */
	public User getUserByUsername(String username);
	
	public User getUserByLogin(String account,String password);
}
