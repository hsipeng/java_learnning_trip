package test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Person;


public class TestDemo {
	//多例与单例
	@Test
	public void test01(){
		ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) c.getBean("person");
		System.out.println(person);
		person.shit();
		c.close();
	}
}
