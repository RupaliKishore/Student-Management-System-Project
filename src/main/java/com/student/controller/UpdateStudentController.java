package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.entity.Student;
import com.student.service.StudentService;

@Controller
public class UpdateStudentController 
{
	@Autowired
	private StudentService service;
	
	
	@GetMapping("/updatestudent/{id}")
	public String updateStudent( Model model, @PathVariable("id") int id)
	{
		model.addAttribute("update", service.getStudentById(id));
		return "UpdateStudent";
	}
	
	
	
	@PostMapping("/saveupdateStudent")
	public String saveUpdateStudent(@ModelAttribute("update") Student student)
	{
		service.saveRegisterform(student);           
		return "redirect:dashboard";
	}
	
	
	// delete by id
	
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") int id)
	{
		service.deleteById(id);
		
		return "redirect:/dashboard";
		
	}
	
	
	// view Student
	
	@GetMapping("/viewstudent/{id}")
	public String viewStudent(Model model, @PathVariable("id") int id)
	{
		model.addAttribute("viewstudent", service.getStudentById(id));
		
		return "StudentView";
	}

}
