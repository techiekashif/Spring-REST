package com.kashif.springboot.CrudAPI.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kashif.springboot.CrudAPI.DAO.EmployeeRepository;
import com.kashif.springboot.CrudAPI.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRespository;

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeRespository.findAll();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		Optional<Employee> result = employeeRespository.findById(id);
		Employee employee = null;
		if(result.isPresent()) {
			employee=result.get();
		}else {
			throw new RuntimeException("Invalid ID : "+id);
		}
		return employee;
	}

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		employeeRespository.save(employee);
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int id) {
		employeeRespository.deleteById(id);
	}

}
