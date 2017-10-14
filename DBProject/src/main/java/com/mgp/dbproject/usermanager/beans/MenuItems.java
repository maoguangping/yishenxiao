package com.mgp.dbproject.usermanager.beans;

import java.io.Serializable;
import java.util.List;

public class MenuItems  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String id;
	
	public List<MenuItem> menuItem;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<MenuItem> getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(List<MenuItem> menuItem) {
		this.menuItem = menuItem;
	}

	@Override
	public String toString() {
		return "MenuItems [id=" + id + ", menuItem=" + menuItem + "]";
	}
}
