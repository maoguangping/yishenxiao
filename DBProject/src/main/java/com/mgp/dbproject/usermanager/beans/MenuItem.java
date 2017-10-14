package com.mgp.dbproject.usermanager.beans;

import java.io.Serializable;
import java.util.List;

public class MenuItem implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String text;

	public List<Items> items;
    
    public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "MenuItem [text=" + text + ", items=" + items + "]";
	}

}
