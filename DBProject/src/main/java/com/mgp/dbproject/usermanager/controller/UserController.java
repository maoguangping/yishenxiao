package com.mgp.dbproject.usermanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mgp.dbproject.usermanager.service.UserService;

@Controller
public class UserController {
	@Autowired(required=false)@Qualifier("userService")
	private UserService userService;
    
	@RequestMapping("deleteUser")
	public @ResponseBody void deleteUser(Long id){
		System.out.println("id: "+id);
		userService.removeUser();
	}
}
