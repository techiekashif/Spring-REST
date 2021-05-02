package com.kashif.springboot.CrudAPI.service;

import java.util.List;

import com.kashif.springboot.CrudAPI.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int id);

	public void addEmployee(Employee employee);

	public void deleteEmployeeById(int id);
}
