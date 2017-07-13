package cn.dao;

import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao {
	@Override
	public void save(String name) {
		System.out.println("姓名："+name);

	}

	@Override
	public void delPerson() {
		System.out.println("删除一个用户");
		
	}

}
