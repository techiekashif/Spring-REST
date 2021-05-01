package com.kashif.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kashif.springdemo.entity.Student;
import com.kashif.springdemo.exceptions.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	@PostConstruct
	private void loadData() {
		students = new ArrayList<Student>();
		students.add(new Student("mohammad", "Kashif"));
		students.add(new Student("Tom", "jerry"));
		students.add(new Student("rob", "nick"));
	}

	@GetMapping("/students")
	public List<Student> showStudents() {
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student showStudentById(@PathVariable int studentId) {
		
		if(studentId>=students.size() || studentId<0) {
			throw new StudentNotFoundException("Student not found for ID :" +studentId);
		}
		
		return students.get(studentId);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
	
	}
	
}
