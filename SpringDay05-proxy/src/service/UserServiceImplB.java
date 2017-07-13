package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dao.UserDao;

@Service(value="userService2")
public class UserServiceImplB implements UserService {
	@Resource
	private UserDao userDao;
	@Override
	public void addUser() {
		System.out.println("我是第二实现类");
		userDao.addUser();

	}

}
