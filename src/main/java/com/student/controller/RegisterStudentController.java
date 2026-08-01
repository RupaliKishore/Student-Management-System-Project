package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.entity.Student;
import com.student.service.StudentService;
@Controller
public class RegisterStudentController 
{
	@Autowired
	private StudentService service;
	
	@RequestMapping("/index")
	public String hello()
	{
		return "index";
	}
	
	
	
	@GetMapping("/register")
	public String createRegisterform(Model model)
	{
		Student student = new Student();
	    model.addAttribute("saveStudent", student);
		return "Register";
	}
	
	@GetMapping("/home")
	public String home()
	{
		return "Home";
	}
	
	// handler method to handle Register form Save request
	@PostMapping("/saveregister")
	public String saveRegisterform( @ModelAttribute("saveStudent") Student student)
	{
		service.saveRegisterform(student);
		
		return "redirect:/dashboard";
	}

}
