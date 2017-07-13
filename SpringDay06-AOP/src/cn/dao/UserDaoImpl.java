package cn.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public void addUser() {
		System.out.println("添加一个用户");

	}

	@Override
	public String countUser() {
	
		return "2017";
	}

	

}
