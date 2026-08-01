package com.student.entity;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
//	@NotEmpty( message = "Required")
	private String firstname;
//	@NotEmpty( message = "Required")
	private String lastname;
//	@NotEmpty( message = "Required")
	private String email;
	//@NotEmpty( message = "Required")
	private String password;
	//@NotEmpty( message = "Required")
	private String mobnum;
//	@NotNull(message = "Required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
//	@NotEmpty( message = "Required")
	private String gender;
//	@NotEmpty( message = "Required")
	private String cource;
//	@NotEmpty( message = "Required")
	private String city;
//	@NotNull( message = "Required")
	private int pincode;
	
	private String resetToken;
	private LocalDateTime  tokenExpiry;
	
	public String getResetToken() {
		return resetToken;
	}
	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}
	public LocalDateTime getTokenExpiry() {
		return tokenExpiry;
	}
	public void setTokenExpiry(LocalDateTime tokenExpiry) {
		this.tokenExpiry = tokenExpiry;
	}
	public int getId() {
		return id;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String firstname, String lastname, String email, String password, String mobnum,
			 Date dob, String gender, String cource, String city, int pincode) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.mobnum = mobnum;
		this.dob = dob;
		this.gender = gender;
		this.cource = cource;
		this.city = city;
		this.pincode = pincode;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobnum() {
		return mobnum;
	}
	public void setMobnum(String mobnum) {
		this.mobnum = mobnum;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob( Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCource() {
		return cource;
	}
	public void setCource(String cource) {
		this.cource = cource;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	

}
