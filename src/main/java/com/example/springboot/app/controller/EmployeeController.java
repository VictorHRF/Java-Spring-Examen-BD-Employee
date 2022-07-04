package com.example.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.app.exception.Mensaje;
import com.example.springboot.app.model.Employee;
import com.example.springboot.app.service.EmployeeService;

@RestController
@RequestMapping("")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/findemployee/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable long id){
		return ResponseEntity.ok().body(employeeService.findEmployeeById(id));
	}
	
	@GetMapping("/findallemployee")
	public ResponseEntity<?> findAllEmployee() {
		List<Employee> lista = employeeService.findAllEmployee();
		if(lista.isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Sin empleados en la base de datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(employeeService.findAllEmployee());
	}
	
	@DeleteMapping("/deleteemployee/{id}")
	public HttpStatus deleteEmployee(@PathVariable long id) {
		this.employeeService.deleteEmployee(id);
		return HttpStatus.OK;
	}
	
	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
		employee.setId(id);
		return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
	}
	
}
