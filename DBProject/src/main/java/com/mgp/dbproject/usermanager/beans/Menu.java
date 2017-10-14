package com.mgp.dbproject.usermanager.beans;

import java.io.Serializable;
import java.util.Date;

public class Menu implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long menuparentid;

    private String menuname;

    private String menuurl;

    private String menudesc;

    private String menutype;

    private String menuicon;

    private String menuperms;

    private Integer menusortnumber;

    private Date menucreatetime;

    private Date menumodifiedtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMenuparentid() {
        return menuparentid;
    }

    public void setMenuparentid(Long menuparentid) {
        this.menuparentid = menuparentid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl == null ? null : menuurl.trim();
    }

    public String getMenudesc() {
        return menudesc;
    }

    public void setMenudesc(String menudesc) {
        this.menudesc = menudesc == null ? null : menudesc.trim();
    }

    public String getMenutype() {
        return menutype;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype == null ? null : menutype.trim();
    }

    public String getMenuicon() {
        return menuicon;
    }

    public void setMenuicon(String menuicon) {
        this.menuicon = menuicon == null ? null : menuicon.trim();
    }

    public String getMenuperms() {
        return menuperms;
    }

    public void setMenuperms(String menuperms) {
        this.menuperms = menuperms == null ? null : menuperms.trim();
    }

    public Integer getMenusortnumber() {
        return menusortnumber;
    }

    public void setMenusortnumber(Integer menusortnumber) {
        this.menusortnumber = menusortnumber;
    }

    public Date getMenucreatetime() {
        return menucreatetime;
    }

    public void setMenucreatetime(Date menucreatetime) {
        this.menucreatetime = menucreatetime;
    }

    public Date getMenumodifiedtime() {
        return menumodifiedtime;
    }

    public void setMenumodifiedtime(Date menumodifiedtime) {
        this.menumodifiedtime = menumodifiedtime;
    }
}