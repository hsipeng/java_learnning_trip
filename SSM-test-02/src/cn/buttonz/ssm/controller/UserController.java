package cn.buttonz.ssm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.buttonz.ssm.pojo.User;
import cn.buttonz.ssm.service.UserService;
import cn.buttonz.ssm.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserServiceImpl userService;
	
	@RequestMapping("/showAllUsers")
	public String toAllUsers(Model model){
		List<User> uList = this.userService.selectAll();
		for (User user : uList) {
			System.out.println(user);
		}
		model.addAttribute("uList",uList);
		return "allUser";
	}
	
	@RequestMapping("/modifyUser")
	public String toModify(HttpServletRequest request,Model model){
		int  userId = Integer.parseInt(request.getParameter("userid"));
		User user = userService.selectById(userId);
		model.addAttribute("user",user);
		return "modifyUser";
	}
	
	@RequestMapping("/updateUser")
	public String doUpdate(User user){
		int i = userService.updateById(user);
		if(i>0){
			System.out.println("修改成功");
		}else {
			System.err.println("修改失败");
		}
		return "forward:/user/showAllUsers";
	}
	@RequestMapping("/delUser")
	public String toDel(HttpServletRequest request){
		int  userId = Integer.parseInt(request.getParameter("userid"));
		int i = userService.delById(userId);
		if(i>0){
			System.out.println("删除成功");
		}else {
			System.err.println("删除失败");
		}
		return "redirect:/user/showAllUsers";
	}
	@RequestMapping("/toAdd")
	public String toAdd(){
		return "addUser";
	}
	@RequestMapping("/addUser")
	public String toAddUser(User user){
		int i = userService.insert(user);
		if(i>0){
			System.out.println("添加成功");
			
		}else {
			System.err.println("添加失败");
		}
		return "redirect:/user/showAllUsers";
	}
}
