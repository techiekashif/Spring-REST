package com.kashif.springboot.CrudAPI.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kashif.springboot.CrudAPI.DAO.EmployeeDAO;
import com.kashif.springboot.CrudAPI.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeDAO.getAllEmployees();

	}
}
