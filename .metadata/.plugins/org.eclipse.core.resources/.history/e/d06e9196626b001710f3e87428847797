package cn.servlet;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import cn.bean.User;
import cn.service.UserService;
@Controller
public class UserServlet {
	@Resource
	private UserService userService;

	public void addUser(User user) {
		userService.addUser(user);

	}


	public void delUser(int id) {
		userService.delUser(id);

	}


	public void updateUser(User user) {
		userService.updateUser(user);

	}


	public List<User> findAll() {
		
		return userService.findAll();
	}


	public User findOne(int id) {
		
		return userService.findOne(id);
	}

}
