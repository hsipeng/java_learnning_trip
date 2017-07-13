package servlet;

import service.UserService;

public class UserServlet {
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void addUser(){
		userService.addUser();
	}
}
