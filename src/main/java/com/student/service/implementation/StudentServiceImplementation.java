package com.student.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
@Service
public class StudentServiceImplementation implements StudentService
{
	@Autowired
	private StudentRepository studentRepository;
	

	@Override
	public Student saveRegisterform(Student student) 
	{
		studentRepository.save(student);
		return student;
	}


	@Override
	public Student login(String email, String password) 
	{
		return studentRepository.findByEmailAndPassword(email, password);
	}

	
	

// ---------------  for forgot password --------------------
	
	@Override
	public boolean sendResetLink(String email) 
	{
		Student student = studentRepository.findByEmail(email);
		if(student == null) return false; // email not found
		
		// Generate a Unique token
		String token = UUID.randomUUID().toString();
		student.setResetToken(token);
		student.setTokenExpiry(LocalDateTime.now().plusMinutes(10)); // for 10min. only valid token
		studentRepository.save(student);
		
		// In a real application, send an email with the reset link:
		// e.g. , e.g., "http://localhost:8083/reset-password?token=" + token
		
		System.err.println("Password reset link (simulate email): " +"http://localhost:8083/reset-password?token=" + token);
		
		return true;
	}


	// for token
	@Override
	public Student validateResetToken(String token)
	{
		Student student = studentRepository.findAll()
				         .stream()
				         .filter(s -> token.equals(s.getResetToken()))
				         .findFirst()
				         .orElse(null);
		
		if(student != null && student.getTokenExpiry() != null && student.getTokenExpiry().isAfter(LocalDateTime.now()))
		{
			return student;
		}
				        		 
		return null; // invalid or expired
	}


	// for new Password method
	@Override
	public boolean updatePassword(Student student, String newPassword)
	{
		if(student ==null) return false;
		
		student.setPassword(newPassword);
		student.setResetToken(null);  // clear token
		student.setTokenExpiry(null);
		
		studentRepository.save(student);
		return true;
	}
// -----------------------------------------------------------------------------------


	// Student List
	@Override
	public List<Student> getAllStudent() 
	{
		return studentRepository.findAll();
	
	}

//  Update Student
	@Override
	public Student getStudentById(int id) 
	{
		return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: "+ id));
		
		
	}

// delete by id
	@Override
	public void deleteById(int id)
	{
		 studentRepository.deleteById(id);
		
	}

	

}
