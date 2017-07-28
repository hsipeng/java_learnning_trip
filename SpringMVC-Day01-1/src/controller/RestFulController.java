package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestFulController {
	@RequestMapping("/toSay/{name}/{age}.action")
	public String say(Model model,@PathVariable String name,@PathVariable int age){
		System.out.println(name+":"+age);
		String msg = name +":"+age;
		model.addAttribute("msg",msg);
		return "hello";
	}
}
