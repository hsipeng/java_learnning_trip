package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.UserMapper;
import pojo.User;
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Override
	public List<User> findAll() {
		
		return userMapper.findAll();
	}

}
