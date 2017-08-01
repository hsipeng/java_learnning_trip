package cn.buttonz.ssm.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.buttonz.ssm.pojo.User;
import cn.buttonz.ssm.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class SSMTest {
	private static Logger logger = Logger.getLogger(SSMTest.class);
	
	@Resource
	 private UserService userService;
	
	@Test
	public void test01(){
		User user = userService.selectById(1);
		logger.info(user);
	}
}
