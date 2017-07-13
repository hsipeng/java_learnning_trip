package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dao.UserDao;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Override
	public void addUser() {
		userDao.addUser();

	}

}
