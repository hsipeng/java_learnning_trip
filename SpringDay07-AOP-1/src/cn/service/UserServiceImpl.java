package cn.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.anno.Hello;
import cn.dao.UserDao;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Override
	@Hello(value="add")
	public void addUser(String name, int age) {
		userDao.addUser(name,age);
		
	}


}
