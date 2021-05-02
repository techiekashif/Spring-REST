package com.kashif.springboot.CrudAPI.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kashif.springboot.CrudAPI.DAO.EmployeeDAO;
import com.kashif.springboot.CrudAPI.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("employeeJPADAOImpl")
	private EmployeeDAO employeeDao;

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		return employeeDao.getEmployeeById(id);
	}

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int id) {
		employeeDao.deleteEmployeeById(id);
	}

}
