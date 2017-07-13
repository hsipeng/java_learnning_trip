package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import proxy.DynamicProxy;
import proxy.DynamiccglibProxy;
import service.UserService;
import tx.TranscationManager;

public class TestDemo {
	@Test
	public void test01(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取目标对象
		UserService target = (UserService)context.getBean("target");
		//获取事务控制对象
		TranscationManager tx = (TranscationManager)context.getBean("tx");
		//通过动态代理模式获取对象
		UserService us = (UserService)DynamicProxy.getProxy(target, tx);
		
		//查看对象类型
		System.out.println(us.getClass());
		us.addUser();
		us.updateUser();
	}
	
	
	@Test
	public void test02(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取目标对象
		UserService target = (UserService)context.getBean("target");
		//获取事务控制对象
		TranscationManager tx = (TranscationManager)context.getBean("tx");
		//通过动态代理模式获取对象
		UserService us = (UserService)DynamiccglibProxy.getProxy(target, tx);
		
		//查看对象类型
		System.out.println(us.getClass());
		us.addUser();
		us.updateUser();
	}
}
