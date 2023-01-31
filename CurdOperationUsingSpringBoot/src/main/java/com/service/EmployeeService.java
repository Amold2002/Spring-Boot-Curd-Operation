package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.repo.EmployeeRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepo employeerepo;

	@Override
	public Employee addEmployee(Employee emp) {
		Employee savedEmployee = employeerepo.save(emp);
		return savedEmployee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeerepo.findAll();
	}

	@Override
	public Employee getEmpById(Long empidl) {
		return employeerepo.findById(empidl).get();
	}

	@Override
	public void deleteByEmpId(Long empidl) {
		
		employeerepo.deleteById(empidl);
	}

}
