package com.mgp.dbproject.usermanager.beans;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long id;

    private String useraccount;

    private String username;

    private String userpassword;

    private String useremail;

    private String userphone;

    private Date usercreatetime;

    private Date usermodifiedtime;

    private Integer userstatus;

    private Integer userislogin;
    
    private Role role;

    @Override
	public String toString() {
		return "User [id=" + id + ", useraccount=" + useraccount
				+ ", username=" + username + ", userpassword=" + userpassword
				+ ", useremail=" + useremail + ", userphone=" + userphone
				+ ", usercreatetime=" + usercreatetime + ", usermodifiedtime="
				+ usermodifiedtime + ", userstatus=" + userstatus
				+ ", userislogin=" + userislogin + ", role=" + role + "]";
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount == null ? null : useraccount.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public Date getUsercreatetime() {
        return usercreatetime;
    }

    public void setUsercreatetime(Date usercreatetime) {
        this.usercreatetime = usercreatetime;
    }

    public Date getUsermodifiedtime() {
        return usermodifiedtime;
    }

    public void setUsermodifiedtime(Date usermodifiedtime) {
        this.usermodifiedtime = usermodifiedtime;
    }

    public Integer getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }

    public Integer getUserislogin() {
        return userislogin;
    }

    public void setUserislogin(Integer userislogin) {
        this.userislogin = userislogin;
    }
}