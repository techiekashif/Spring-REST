package com.kashif.springboot.CrudAPI.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kashif.springboot.CrudAPI.entity.Employee;

@Repository
public class EmployeeHibernateDaoImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	

	@Override
	public List<Employee> getAllEmployees() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;

	}

	@Override
	public Employee getEmployeeById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee emp = currentSession.get(Employee.class, id);
		return emp;
	}

	@Override
	public void addEmployee(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteEmployeeById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", theId);
		query.executeUpdate();
	}
	
	

}
