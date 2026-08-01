package com.student.Student.Management.System.Pro_1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.student.entity")
@ComponentScan(basePackages = {
		                    "com.student.controller",
		                    "com.student.service",
		                    "com.student.service.implementation"
                             })
@EnableJpaRepositories("com.student.repository")
@SpringBootApplication
public class StudentManagementSystemPro1Application implements CommandLineRunner
{

	public static void main(String[] args) 
	{
		SpringApplication.run(StudentManagementSystemPro1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		
		
	}

}
