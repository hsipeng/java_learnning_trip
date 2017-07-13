package dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public void addUser() {
		System.out.println("添加一个用户");
	}

	@Override
	public void updateUser() {
		System.out.println("修改一个用户");
		
	}

}
