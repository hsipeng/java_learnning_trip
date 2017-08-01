package cn.buttonz.ssm.service;

import java.util.List;

import cn.buttonz.ssm.pojo.User;

public interface UserService {
	List<User> selectAll();
	int insert(User user);
	User selectById(int id);
	int updateById(User user);
	int delById(int userId);
}
