package com.example.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.springboot.app.model.Employee;
import com.example.springboot.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee findEmployeeById(long employeeId) {
		
		Optional<Employee> employeeDb = this.employeeRepository.findById(employeeId);
		
		if(employeeDb.isPresent()) {
			return employeeDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + employeeId); 
		}
		
	}
	
	@Override
	public List<Employee> findAllEmployee() {
		return this.employeeRepository.findAll();
	}
	
	@Override
	public void deleteEmployee(long employeeId) {
		
		Optional<Employee> employeeDb = this.employeeRepository.findById(employeeId);
		
		if(employeeDb.isPresent()) {
			this.employeeRepository.delete(employeeDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + employeeId); 
		}
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		
		Optional<Employee> employeeDb = this.employeeRepository.findById(employee.getId());
		
		if(employeeDb.isPresent()) {
			Employee employeeUpdate = employeeDb.get();
			employeeUpdate.setSurname(employee.getSurname());
			employeeUpdate.setFistname(employee.getFistname());
			employeeRepository.save(employeeUpdate);
			return employeeUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + employee.getId()); 
		}
	}
	
}
