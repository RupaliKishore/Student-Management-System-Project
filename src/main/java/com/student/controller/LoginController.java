package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.entity.Student;
import com.student.service.StudentService;

@Controller
public class LoginController
{

	@Autowired
	private StudentService service;
	
	
	@GetMapping("/login")
	public String loginpage(Model model)
	{
		 model.addAttribute("login", new Student());
		 return "Login";
	}
	
	
	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, Model model)
	{
		Student student = service.login(email, password);
		if(student != null)
		{
			// Login Successfull == redirect home
			return "redirect:/dashboard";
		}
		else
		{
			// Login Failed == show error message
			model.addAttribute("error", "Invalid Email or Password");
			
			return "Login";
		}
	}
	
	

}
