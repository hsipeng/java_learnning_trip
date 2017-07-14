package cn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import cn.aspect.Myaspect;
import cn.dao.Person;
import cn.dao.PersonImpl;
import cn.service.PersonService;
import cn.service.PersonServiceImpl;
import cn.servlet.PersonServlet;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class PriviConfig {
	@Bean
	public PersonServlet personServlet(){
		return new PersonServlet();
	}
	
	@Bean
	public PersonService personService(){
		return new PersonServiceImpl();
	}
	
	@Bean
	public Person person(){
		return new PersonImpl();
	}
	
	@Bean
	public Myaspect myaspect(){
		return new Myaspect();
	}
}
