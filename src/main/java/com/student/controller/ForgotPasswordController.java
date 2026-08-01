package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.entity.Student;
import com.student.service.StudentService;

@Controller
public class ForgotPasswordController 
{
	@Autowired
	private StudentService service;
	
	
	// show forgot password page (enter email)
	
	@GetMapping("/forgot-password")
	public String showForgotForm()
	{
		return "ForgotPassword";  // ForgotPassword.html page
	}
	
	
	
	// process email submission
	@PostMapping("/forgot-password")
	public String processForgotEmail(@RequestParam String email, Model model)
	{
		boolean sent = service.sendResetLink(email);
		if(sent)
		{
			model.addAttribute("message", "A Password reset link has been sent to your email (check console).");
		}
		else
		{
			model.addAttribute("error", "Email address not found");
		}
		return "ForgotPassword";
	}
	
	
	// show reset password form (accessed via link  with token)
	@GetMapping("/reset-password")
	public String showResetForm(@RequestParam String token, Model model)
	{
		Student student = service.validateResetToken(token);
		if(student == null)
		{
			model.addAttribute("error", "Invalid or Expired reset token link");
			return "ResetPassword"; // still show form but with error
		}
		model.addAttribute("token", token);
		model.addAttribute("studnet", student);
		return "ResetPassword";
	}
	
	
	@RequestMapping("/dashboard")
	public String hello()
	{
		return "Dashboard";
	}
	
	
	
	// process password reset 
	@PostMapping("/reset-password")
	public String processReset(@RequestParam String token, @RequestParam String newPassword, @RequestParam String confirmPassword, Model model)
	{
		if(!newPassword.equals(confirmPassword))
		{
			model.addAttribute("error", "Password do not match");
			model.addAttribute(token, token);
			return "resetPassword";
		}
		
		Student student = service.validateResetToken(token);
		if(student == null)
		{
			model.addAttribute("error", "Invalid or Expired reset link");
			return "ResetPassword";
		}
		
		service.updatePassword(student, newPassword);
		model.addAttribute("message", "Password reset successfully!, you can now login.");
		return "redirect:/dashboard";// or redirect to login
	}

}
