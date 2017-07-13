package cn.servlet;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import cn.service.UserService;
@Controller
public class UserServlet {
	@Resource
	private UserService userService;
	
	
	public void addUser(){
		String name ="战三";
		int age = 1;
		userService.addUser(name,age);
	}
	
}
