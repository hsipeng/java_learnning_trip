package cn.service;

import java.sql.SQLException;
import java.util.List;

import cn.bean.User;

public interface UserService {
	public void addUser(User user) throws SQLException;
	public void delUser(int id);
	public void updateUser(User user);
	public List<User> findAll();
	public User findOne(int id);
}
