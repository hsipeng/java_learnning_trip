package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import cn.service.UserService;
import cn.servlet.UserServlet;


public class testAOP {

	
	@Test
	public void test2(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServlet userServlet = (UserServlet) context.getBean("userServlet");
		userServlet.addUser();
		
		
	}
}
