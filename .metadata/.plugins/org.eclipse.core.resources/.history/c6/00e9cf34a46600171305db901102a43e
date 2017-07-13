package cn.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dao.UserDao;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public void addUser() {
		userDao.addUser();

	}

	
	public void delUser() {

		System.out.println("删除一个用户");
		
	}


	@Override
	public String countUser() {
		return userDao.countUser();
	}

}
