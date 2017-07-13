package test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import servlet.UserServlet;

public class TestDemo {
	@Test
	public void test01(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServlet userServlet=(UserServlet)context.getBean("userServlet");
		System.out.println(userServlet);
		userServlet.addUser();
	}
}
