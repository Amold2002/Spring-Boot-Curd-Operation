package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.repo.EmployeeRepo;
import com.service.EmployeeServiceInterface;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;

	@PostMapping("/Insert")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {

		System.out.println("saving the employee");
		Employee employeeSaved = employeeServiceInterface.addEmployee(emp);

		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
	}

	@GetMapping("/SelectById/{empid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("empid") Long Empidl) {
		Employee emp = employeeServiceInterface.getEmpById(Empidl);

		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@GetMapping("/Select")
	public ResponseEntity<List<Employee>> getEmpAll() {
		List<Employee> listOfAllEmps = employeeServiceInterface.getAllEmployee();

		return new ResponseEntity<List<Employee>>(listOfAllEmps, HttpStatus.OK);
	}

	@DeleteMapping("/Delete/{empid}")
	public ResponseEntity<Void> deleteEmpAll(@PathVariable("empid") Long Empidl) {
		employeeServiceInterface.deleteByEmpId(Empidl);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/Update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {

		System.out.println("saving the employee");
		Employee employeeSaved = employeeServiceInterface.addEmployee(emp);

		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
	}

}
