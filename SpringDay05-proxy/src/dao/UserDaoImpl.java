package dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import bean.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Resource
	private User user;
	@Override
	public void addUser() {
		System.out.println("add user \n userid is "+user.getId()+"\n name is "+user.getName());

	}

}
