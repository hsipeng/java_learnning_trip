package cn.dao;

import java.util.List;

import cn.bean.User;

public interface UserDao {
	public void addUser(User user);
	public void delUser(int id);
	public void updateUser(User user);
	public List<User> findAll();
	public User findOne(int id);
}
