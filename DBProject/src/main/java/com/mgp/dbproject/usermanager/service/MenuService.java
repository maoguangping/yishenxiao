package com.mgp.dbproject.usermanager.service;

import java.util.List;

import com.mgp.dbproject.usermanager.beans.Menu;

public interface MenuService {
    public int insertMenuService(Menu menu);
    public List<Menu> getMenuByUserId(Long id);
    public List<Menu> getMenuByRoleId(Long id);
}
