package test;

import java.util.Calendar;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Hello;
import beans.Student;

public class TestDemo {
	//通过默认的构造方法创建对象
	@Test
	public void test01(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取对象
//		Hello hello = (Hello) context.getBean("大大大");
		Student student = (Student) context.getBean("student");
		student.say();
	}
	
	//通过静态工厂创建对象
	@Test
	public void test02(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取对象
		Calendar calendar = (Calendar) context.getBean("calendar1");
		System.out.println(calendar.getTime());
	}
	
	//实例工厂
	@Test
	public void test03(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取对象
		Calendar calendar = (Calendar) context.getBean("calendar2");
		System.out.println(calendar.getTime());
	}
}
