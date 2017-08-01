package service;

import java.util.List;

import javax.annotation.Resource;

import mapper.UserMapper;

import org.springframework.stereotype.Service;

import pojo.User;
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	
	
	public List<User> findAll() {
		
		return userMapper.findAll();
	}

}
