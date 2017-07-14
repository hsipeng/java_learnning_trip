package cn.servlet;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import cn.service.PersonService;

@Controller
public class PersonServlet {
	@Resource
	private PersonService personService;
	
	public void save(){
		personService.save();
	}
	
	public void del(){
		personService.del();
	}
}
