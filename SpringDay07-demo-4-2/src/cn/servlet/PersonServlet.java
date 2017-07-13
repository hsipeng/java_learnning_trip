package cn.servlet;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import cn.service.PersonService;

@Controller
public class PersonServlet {
	@Resource
	private PersonService personService;
	public String save(String name){
		personService.save(name);
		return name;
	}
	public void del(){
		personService.delete();
	}
	public void findAll(){
		personService.findAll();
	}
}
