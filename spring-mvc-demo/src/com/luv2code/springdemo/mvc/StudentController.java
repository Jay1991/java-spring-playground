package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}") 
    private Map<String, String> countryOptions;
	
    private Map<String, String> favoriteLanguageOptions;
    
    public StudentController() {
    	favoriteLanguageOptions = new LinkedHashMap<String, String>();
    	favoriteLanguageOptions.put("C#", "C#");
    	favoriteLanguageOptions.put("Java", "Java");
    	favoriteLanguageOptions.put("PHP", "PHP");
    	favoriteLanguageOptions.put("Ruby", "Ruby");
    	favoriteLanguageOptions.put("Javascript", "Javascript");
    }
    
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		// create a new student object
		Student student = new Student();
		
		// add that student object as a model attribute
		model.addAttribute("student", student);
		model.addAttribute("countryOptions", countryOptions);
		model.addAttribute("favoriteLanguageOptions", favoriteLanguageOptions);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return "student-confirmation";
	}
	
}
