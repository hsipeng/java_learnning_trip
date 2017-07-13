package cn.servlet;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
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
}
