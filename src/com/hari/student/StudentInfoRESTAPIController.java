package com.hari.student;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StudentInfoRESTAPIController {
//	@ResponseBody
	@RequestMapping(value = "/student", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	public ArrayList<Student> getStudentList(){
		Student student1 = new Student();
		student1.setStudentName("One");

		Student student2 = new Student();
		student2.setStudentName("Two");

		Student student3 = new Student();
		student3.setStudentName("Three");

		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		return studentList;
	}

//	@ResponseBody
	@RequestMapping(value = "/student/{name}", method = RequestMethod.GET)
	public Student  getStuden(@PathVariable("name") String studentName){
		Student student1 = new Student();
		student1.setStudentName(studentName);
		return student1;
	}

	@RequestMapping(value = "/student/{name}", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateStudent(@PathVariable("name")String studentName, @RequestBody Student student){
		System.out.println("Update Student Record");
		HttpHeaders headers =new HttpHeaders();
		headers.add("key1","value1");
		headers.add("key2","value2");
		return new ResponseEntity<Boolean>(true,headers,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/students}", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> createStudent( @RequestBody Student student){
		System.out.println("Create new Student Record. "+student.getStudentName()+student.getStudentHobby());
		HttpHeaders headers =new HttpHeaders();
		headers.add("Location",ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(student.getStudentName()).toUri().toString());
		return new ResponseEntity<Boolean>(true,headers,HttpStatus.CREATED);
	}	
	
	@RequestMapping(value = "/student/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("name")String studentName){
		System.out.println("Delete Student Record"+studentName);
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/students", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAllStudents(){
		System.out.println("Delete Student Record");
		HttpHeaders headers =new HttpHeaders();
		headers.add("key1","value1");
		headers.add("key2","value2");
		return new ResponseEntity<Boolean>(true,headers,HttpStatus.OK);
	}
}
