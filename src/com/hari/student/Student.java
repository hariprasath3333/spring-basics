package com.hari.student;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"studentSkills"})
@JsonPropertyOrder({"studentDOB","studentHobby","studentName"})
public class Student {
	@Pattern(regexp="[^0-9]*")
	@JsonProperty("student_name")
	private String studentName;
	
	@Size(min = 2, max = 30, message ="Please enter a valid hobby value between {min} and {max}")
	@IsValidHobby(listOfValidHobbies = "swimming|music|Music|Swimming")
	private String studentHobby;
	
	@Past
	private Date studentDOB;
	private ArrayList<String>studentSkills;
	private Address studentAddress;
	
	public void setStudentAddress(Address studentAddress){
		this.studentAddress = studentAddress;
	}

	public void setStudentName(String name){
		this.studentName = name;
	}
	
	public void setStudentHobby(String hobby){
		this.studentHobby = hobby;
	}
	
	public void setStudentDOB( Date studentDOB){
		this.studentDOB = studentDOB;
	}
	
	public void setStudentSkills(ArrayList<String> studentSkills){
		this.studentSkills = studentSkills;
	}
	
	public Address  getStudentAddress(){
		return studentAddress;
	}

	public String getStudentName(){
		return studentName;
	}
	
	public String getStudentHobby(){
		return studentHobby;
	}
	
	public Date getStudentDOB(){
		return studentDOB;
	}
	
	public ArrayList<String> getStudentSkills(){
		return studentSkills;
	}
}
