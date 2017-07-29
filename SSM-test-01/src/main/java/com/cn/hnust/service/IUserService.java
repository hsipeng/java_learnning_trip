package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.User;

public interface IUserService {
	public User getUserById(int userId);
	public List<User> selectAll();
	public int deleteByPrimaryKey(int userId);
	int updateByPrimaryKey(User user);
	int insert(User user);
}
