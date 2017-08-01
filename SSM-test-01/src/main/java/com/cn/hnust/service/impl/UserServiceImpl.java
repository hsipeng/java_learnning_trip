package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IUserDao;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}
	@Override
	public List<User> selectAll() {
		
		return userDao.selectAll();
	}
	@Override
	public int deleteByPrimaryKey(int userId) {
		
		return userDao.deleteByPrimaryKey(userId);
	}
	@Override
	public int updateByPrimaryKey(User user) {
		
		return userDao.updateByPrimaryKey(user);
	}
	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return userDao.insert(user);
	}

}