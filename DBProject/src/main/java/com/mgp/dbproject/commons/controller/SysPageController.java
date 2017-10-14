package com.mgp.dbproject.commons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统页面视图
 * 
 * @author 毛广平
 * @date 2017年07月24日
 */
@Controller
@RequestMapping("page")
public class SysPageController {
	

	@RequestMapping("{url}")
	public String page(@PathVariable("url") String url,String type){
		
		if(type == null) {
			return url+".html";
		}
		return  type+"/"+url+".html" ;

	}
	
	
}
