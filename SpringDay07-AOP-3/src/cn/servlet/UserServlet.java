package cn.servlet;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import cn.service.UserService;
@Controller
public class UserServlet {
	@Resource
	private UserService userService;
	
	
	public int addUser(){
		int year = userService.addUser(2017);
		return year;
	}
	
}
