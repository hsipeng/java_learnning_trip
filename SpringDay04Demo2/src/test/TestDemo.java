package test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.BaseDao;
import dao.PersonDao;
import dao.UserDao;
import servlet.UserServlet;

public class TestDemo {
	
	@Test
	public void test02(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao=(UserDao)context.getBean("userDao");
		PersonDao personDao=(PersonDao)context.getBean("personDao");
		BaseDao baseDao=(BaseDao)context.getBean("baseDao");
		baseDao.testDB();
		personDao.addPerson();
		userDao.addUser();
		
	}
}
