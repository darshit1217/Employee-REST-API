package com.api.springrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.springrestapi.model.Employee;
import com.api.springrestapi.service.EmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService eService;
	
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.version}")
	private String appVersion;
	
	@GetMapping("/version")
	public String getAppDetails() {
		return "App name: "+appName+" --App Version: "+appVersion;
	}
//	localhost:8080/employees?pageNumber=1&pageSize=3
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber,@RequestParam Integer pageSize) {
		return new ResponseEntity<List<Employee>>(eService.getEmployees(pageNumber,pageSize),HttpStatus.OK);
	}
//	localhost:8080/employees/4545
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		return new ResponseEntity<Employee>(eService.getSingleEmployee(id),HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
		return new ResponseEntity<Employee>(eService.saveEmployee(employee),HttpStatus.CREATED); 
	}
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
//		System.out.println("updating employee details for the id "+id);
		employee.setId(id); // this statement is for updating the object instead of creating the new record
		return new ResponseEntity<Employee>(eService.updateEmployee(employee),HttpStatus.OK);
	}
	//	localhost:8080/employees?id=34
	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
		eService.deleteEmployee(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
//	localhost:8080/employees/filterByName?name=Saumya
	@GetMapping("/employees/filterByName")
	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByName(name),HttpStatus.OK);
	}

//	localhost:8080/employees/filterByNameAndLocation?name=Saumya&location=Bangalore
	@GetMapping("/employees/filterByNameAndLocation")
	public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name,@RequestParam String location){
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameAndLocation(name, location),HttpStatus.OK);
	}
	
//	localhost:8080/employees/filterByKeyword?keyword=sh
	@GetMapping("/employees/filterByKeyword")
	public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String keyword){
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByKeyword(keyword),HttpStatus.OK);
	}
	
//	localhost:8080/employees/{name}/{location}/{anotherLocation}
	@GetMapping("/employees/{name}/{location}/{anotherLocation}")
	public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(@PathVariable String name,@PathVariable String location,@PathVariable String anotherLocation){
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameOrLocation(name, location,anotherLocation),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/employees/delete/{name}")
	public ResponseEntity<String> deleteEmployeeByName(@PathVariable String name){
		return new ResponseEntity<String>(eService.deleteEmployeeByName(name)+" No. of records deleted",HttpStatus.OK);
	}
}
//@PostMapping
//@DeleteMapping
//@PutMapping
