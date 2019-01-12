package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "HelloWorld-showForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "HelloWorld-processForm";
	}
	
	@RequestMapping("/shout")
	public String shoutIt(HttpServletRequest request, Model model) {
		String name = request.getParameter("name").toUpperCase();
		
		model.addAttribute("message", "Yo!" + name);
		
		return "HelloWorld-processFormShout";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("name") String name, Model model) {
		model.addAttribute("message", "Yo!" + name);
		
		return "HelloWorld-processFormShout";
	}
}
