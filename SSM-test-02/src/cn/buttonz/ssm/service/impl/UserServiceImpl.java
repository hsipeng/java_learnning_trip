package cn.buttonz.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.buttonz.ssm.dao.UserDao;
import cn.buttonz.ssm.pojo.User;
import cn.buttonz.ssm.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userdao;
	@Override
	public List<User> selectAll() {
		
		return userdao.selectAll();
	}

	@Override
	public int insert(User user) {
		
		return userdao.insert(user);
	}

	@Override
	public User selectById(int id) {
		
		return userdao.selectById(id);
	}

	@Override
	public int updateById(User user) {

		return userdao.updateById(user);
	}

	@Override
	public int delById(int userId) {
		
		return userdao.delById(userId);
	}

}
