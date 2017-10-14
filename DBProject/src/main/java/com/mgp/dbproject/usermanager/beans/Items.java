package com.mgp.dbproject.usermanager.beans;

import java.io.Serializable;

public class Items implements Serializable {
	/**
   * 
   */
	private static final long serialVersionUID = 1L;
	public String id;
	public String text;
	public String href;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", text=" + text + ", href=" + href + "]";
	}

}
