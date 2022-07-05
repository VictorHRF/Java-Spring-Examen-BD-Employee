package com.example.springboot.app.service;

import java.util.List;

import com.example.springboot.app.model.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee employee);
	
	Employee findEmployeeById(long employeeId);
	
	List<Employee> findAllEmployee();
	
	void deleteEmployee(long employeeId);
	
	Employee updateEmployee(Employee employee);

}
