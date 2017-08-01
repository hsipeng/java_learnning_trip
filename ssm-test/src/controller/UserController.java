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
	public String toFindAll(Model model){
		List<User> uList = userService.findAll();
		model.addAttribute("uList",uList);
		return "userList";
	}
}
