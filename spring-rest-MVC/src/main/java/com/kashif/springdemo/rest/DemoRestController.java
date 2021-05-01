package com.kashif.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kashif.springdemo.entity.Student;

@RestController
@RequestMapping("/test")
public class DemoRestController {

	// add code for the "/hello" endpoint

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}

	@GetMapping("/students")
	public List<Student> showStudents() {

		List<Student> students = new ArrayList<Student>();

		students.add(new Student("mohammad", "Kashif"));
		students.add(new Student("Tom", "jerry"));
		students.add(new Student("rob", "nick"));

		return students;

	}
}
