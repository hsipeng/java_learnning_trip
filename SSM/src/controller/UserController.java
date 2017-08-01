package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.User;
import service.UserService;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	
	@RequestMapping("/findAll.action")
	public String findAll(Model model){
		
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "userList";
	}
}
