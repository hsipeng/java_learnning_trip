package service;

import dao.UserDao;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void addUser() {
		userDao.addUser();
		
	}
}
