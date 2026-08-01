package com.student.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.student.service.StudentService;

@Controller
public class DashboardController
{
	@Autowired
	private StudentService service;
	
	// show all student
	@GetMapping("/dashboard")
	public String getAllStudent( Model model)
	{
		 model.addAttribute("allStudent", service.getAllStudent());
		return "Dashboard";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
