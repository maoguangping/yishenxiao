package com.mgp.dbproject.usermanager.beans;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long userid;

    private String operatetype;

    private Date createtime;

    private String operatemodel;

    private String operatedesc;

    private String operateip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getOperatetype() {
        return operatetype;
    }

    public void setOperatetype(String operatetype) {
        this.operatetype = operatetype == null ? null : operatetype.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getOperatemodel() {
        return operatemodel;
    }

    public void setOperatemodel(String operatemodel) {
        this.operatemodel = operatemodel == null ? null : operatemodel.trim();
    }

    public String getOperatedesc() {
        return operatedesc;
    }

    public void setOperatedesc(String operatedesc) {
        this.operatedesc = operatedesc == null ? null : operatedesc.trim();
    }

    public String getOperateip() {
        return operateip;
    }

    public void setOperateip(String operateip) {
        this.operateip = operateip == null ? null : operateip.trim();
    }
}