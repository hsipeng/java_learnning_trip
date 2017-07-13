package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.UserDao;
import tx.TranscationManager;

@Service("target")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Resource
	private TranscationManager tsm;
	@Override
	public void addUser() {
		userDao.addUser();
			
	}
	@Override
	public void updateUser() {
		userDao.updateUser();
			
		
	}

}
