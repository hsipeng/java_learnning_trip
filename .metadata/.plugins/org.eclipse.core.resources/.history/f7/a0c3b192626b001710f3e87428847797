package cn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bean.User;
import cn.dao.UserDao;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Override
	public void addUser(User user) {
		userDao.addUser(user);

	}

	@Override
	public void delUser(int id) {
		userDao.delUser(id);

	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);

	}

	@Override
	public List<User> findAll() {
		
		return userDao.findAll();
	}

	@Override
	public User findOne(int id) {
		
		return userDao.findOne(id);
	}

}
