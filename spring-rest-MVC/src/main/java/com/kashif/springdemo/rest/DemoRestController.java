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

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
}
