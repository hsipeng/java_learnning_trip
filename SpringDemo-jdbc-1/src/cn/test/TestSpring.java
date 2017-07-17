package cn.test;


import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bean.User;
import cn.servlet.UserServlet;



public class TestSpring {
	ApplicationContext context = null;
	//before 每当执行@Test时，都会先执行
	@Before
	public void Init(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");

	}
	@Test
	public void test01() throws SQLException{
		UserServlet userServlet = (UserServlet)context.getBean("userServlet");
		List<User> userList = userServlet.findAll();
		for (User user : userList) {
			System.out.println(user);
		}
		
	}
	
	@Test
	public void test03() throws SQLException{
		UserServlet userServlet = (UserServlet)context.getBean("userServlet");
		User user = new User();
		user.setName("abcdefg");
		user.setAge(303);
		user.setId(7);
		userServlet.addUser(user);
		System.out.println(user);
		
	}
	@Test
	public void test02() throws SQLException{
		UserServlet userServlet = (UserServlet)context.getBean("userServlet");
		User user = new User();
		user.setName("saf");
		user.setAge(3030);
		user.setId(2);
		userServlet.updateUser(user);
		System.out.println(user);
		
	}
	@Test
	public void test04() throws SQLException{
		UserServlet userServlet = (UserServlet)context.getBean("userServlet");
		
		userServlet.delUser(7);
		System.out.println("del");
		
	}
	@Test
	public void test05() throws SQLException{
		UserServlet userServlet = (UserServlet)context.getBean("userServlet");
		
		User user = userServlet.findOne(8);
		System.out.println(user);
		
	}
	
}