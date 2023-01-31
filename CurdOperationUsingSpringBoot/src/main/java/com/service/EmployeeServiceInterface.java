package com.service;

import java.util.List;

import com.entity.Employee;

public interface EmployeeServiceInterface {

	Employee addEmployee(Employee emp);

	List<Employee> getAllEmployee();

	Employee getEmpById(Long empidl);

	void deleteByEmpId(Long empidl);

}
