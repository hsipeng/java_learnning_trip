package cn.test;


import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.servlet.PersonServlet;
import cn.util.Privilege;


public class TestSpring {
	@Test
	public void testprivilege(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonServlet ps =(PersonServlet)context.getBean("personServlet");
		List<String> pList = new ArrayList<String>();
		
		pList.add("save");
		pList.add("de");
		
		Privilege.setpList(pList);
//		ps.del();
		ps.save();
		
		
		
	}
}
