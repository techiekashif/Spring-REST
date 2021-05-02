package com.kashif.springboot.CrudAPI.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kashif.springboot.CrudAPI.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
