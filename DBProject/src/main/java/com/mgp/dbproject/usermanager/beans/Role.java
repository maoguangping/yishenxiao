package com.mgp.dbproject.usermanager.beans;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long id;

    private String rolename;

    private String roledesc;

    private Date rolecreatetime;

    private Date rolemodifiedtime;

    private Integer rolestatus;
    
    private Menu menu;

    public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    @Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + ", roledesc="
				+ roledesc + ", rolecreatetime=" + rolecreatetime
				+ ", rolemodifiedtime=" + rolemodifiedtime + ", rolestatus="
				+ rolestatus + ", menu=" + menu + "]";
	}

	public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc == null ? null : roledesc.trim();
    }

    public Date getRolecreatetime() {
        return rolecreatetime;
    }

    public void setRolecreatetime(Date rolecreatetime) {
        this.rolecreatetime = rolecreatetime;
    }

    public Date getRolemodifiedtime() {
        return rolemodifiedtime;
    }

    public void setRolemodifiedtime(Date rolemodifiedtime) {
        this.rolemodifiedtime = rolemodifiedtime;
    }

    public Integer getRolestatus() {
        return rolestatus;
    }

    public void setRolestatus(Integer rolestatus) {
        this.rolestatus = rolestatus;
    }
}