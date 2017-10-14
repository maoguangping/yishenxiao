package com.mgp.dbproject.commons.utils;

import java.util.HashMap;

public class ReturnInfo extends HashMap<String,Object>{

	private static final long serialVersionUID = 1L;
	public int code;
	public Object msg;
	
	public ReturnInfo(){
		this.put("code", 200);
	}
	
	public ReturnInfo put(String key, Object value){
		super.put(key, value);
		return this;
	}
	
    public static ReturnInfo info(int code, Object msg){
    	ReturnInfo info = new ReturnInfo();
    	info.put("code", code);
		info.put("msg", msg);
		return info;
	}
	
    public static ReturnInfo ok(){
		return new ReturnInfo();
	}
    
	public static ReturnInfo ok(String msg){
		ReturnInfo info = new ReturnInfo();
	    info.put("msg", msg);
		return info;
	}
	
	public static ReturnInfo error(){
		return error(500, "服务器未知异常！");
	}
	
	public static ReturnInfo error(String msg){
		return error(500, msg);
	}
    
	public static ReturnInfo error(int code, String msg){
		ReturnInfo info = new ReturnInfo();
		info.put("code", code);
	    info.put("msg", msg);
		return info;
	}
	
}
