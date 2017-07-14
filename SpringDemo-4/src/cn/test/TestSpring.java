package cn.test;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.config.PriviConfig;
import cn.servlet.PersonServlet;
import cn.util.Privilege;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PriviConfig.class)
public class TestSpring {
	@Resource
	private PersonServlet ps;
	@Test
	public void testprivilege(){
//		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(PriviConfig.class);
//		PersonServlet ps =(PersonServlet)context.getBean("personServlet");
		
		List<String> pList = new ArrayList<String>();	
		pList.add("save");
		pList.add("de");	
		Privilege.setpList(pList);
//		ps.del();
		ps.save();
	}
}
