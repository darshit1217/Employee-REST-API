package com.api.springrestapi.service;

import java.util.List;

import com.api.springrestapi.model.Employee;

public interface EmployeeService {
	
//	Get all employess
	List<Employee> getEmployees(int pageNumber,int pageSize);
	
//	create an employee record
	Employee saveEmployee(Employee employee);
	
//	get employee by id and if employee does not exist throw runtime exception
	Employee getSingleEmployee(Long id);
	
//	delete employee by id
	void deleteEmployee(Long id);

//  update employee details	
	Employee updateEmployee(Employee employee);
	
//	method to get employees by name
	List<Employee> getEmployeesByName(String name);
	
//	method to get employees by name and location
	List<Employee> getEmployeesByNameAndLocation(String name,String location);
	
//	method to get employees by name like
	List<Employee> getEmployeesByKeyword(String keyword);
	
//	method to get employees either by name or by location or by anotherLocation-> JPQL query method in EmployeeRepository meant for it
	List<Employee>getEmployeesByNameOrLocation(String name,String location,String anotherLocation);
	
//	method to Delete employees by name
	Integer deleteEmployeeByName(String name);
}
