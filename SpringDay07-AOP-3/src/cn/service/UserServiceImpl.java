package cn.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import cn.dao.UserDao;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Override
	public int addUser(int year) {
		int i = 1/0;
		userDao.addUser();
		return year;
	}


}
