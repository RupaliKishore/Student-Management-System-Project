package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface StudentService 
{
	Student saveRegisterform(Student student);
	
	// login page check email& password
	Student login(String email, String password);
	
	
	// --------------  new method for forgot password -----------------
	
	boolean sendResetLink(String email); // return true if email exist
	Student validateResetToken(String token); // return student if token valid
	boolean updatePassword(Student student , String newPassword);
	
	
	
	// ------  list Student
	public List<Student> getAllStudent();
	
	
	// Update Student
	
	 Student getStudentById(int id);
	 
	 
	 // delete by id
	 void deleteById(int id);
	 
	 
	
}
