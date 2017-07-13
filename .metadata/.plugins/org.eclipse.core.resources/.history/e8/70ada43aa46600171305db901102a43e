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
	
	//计算当前用户
	public void countUser(){
		String number = userService.countUser();
		System.out.println("总数为："+number);
	}
}
