package dao;


import models.User;

public interface UserDao {
	//添加用户
	public abstract boolean Add(User user);
	
	//根据用户名查询用户
	public abstract User findUserByName(String username);
}
