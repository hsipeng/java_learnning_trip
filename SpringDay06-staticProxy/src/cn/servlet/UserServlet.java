package cn.servlet;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import cn.service.UserService;
@Controller
public class UserServlet {
	@Resource
	private UserService userService;
	
	public void addUser(){
		userService.addUser();
	}
	
	public void countUser(){
		int count = userService.countUser();
		System.out.println("人数"+count);
	}
}
