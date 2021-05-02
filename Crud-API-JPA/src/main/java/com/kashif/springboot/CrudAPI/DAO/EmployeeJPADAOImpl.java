package com.kashif.springboot.CrudAPI.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.kashif.springboot.CrudAPI.entity.Employee;

@Repository
public class EmployeeJPADAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getAllEmployees() {

		Query theQuery = entityManager.createQuery("from Employee");
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {

		Employee employee = entityManager.find(Employee.class, id);
		if (employee == null) {
			throw new RuntimeException("Invalid ID : " + id);
		}
		return employee;

	}

	@Override
	public void addEmployee(Employee employee) {
		//Will only save the entity and not update it
		//entityManager.persist(employee);  
	//will save(when id is 0) as well as update entity when id is passed
		entityManager.merge(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		Employee tempEmp = entityManager.find(Employee.class, id);
		if (tempEmp == null) {
			throw new RuntimeException("Invalid ID : " + id);
		}
		Query deleteQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		deleteQuery.setParameter("employeeId", id);
		deleteQuery.executeUpdate();

	}

}
