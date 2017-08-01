package cn.buttonz.ssm.dao;

import java.util.List;

import cn.buttonz.ssm.pojo.User;

public interface UserDao {
	List<User> selectAll();
	int insert(User user);
	User selectById(int id);
	int updateById(User user);
	int delById(int userId);
}
