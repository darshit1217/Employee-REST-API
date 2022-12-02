package com.api.springrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.api.springrestapi.model.Employee;
import com.api.springrestapi.respository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
	@Autowired
	private EmployeeRepository eRepository;
	
	@Override
	public List<Employee> getEmployees(int pageNumber,int pageSize) {
//		returns list of all employees
		Pageable pages=PageRequest.of(pageNumber, pageSize,Direction.DESC,"id");
//		Pageable pages=PageRequest.of(pageNumber, pageSize,Direction.DESC,"id","name");
		return eRepository.findAll(pages).getContent();
	}

//	in this employee object does not contain ID so save method will create new record in the database
	@Override
	public Employee saveEmployee(Employee employee) {
		return eRepository.save(employee);
	}

	@Override
	public Employee getSingleEmployee(Long id) {
		Optional<Employee> employee=eRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("Employee is not found for the id "+id);
	}

	@Override
	public void deleteEmployee(Long id) {
		eRepository.deleteById(id);
	}

//	in this employee object contains the id so the save method treats it as existing object and update the object
	@Override
	public Employee updateEmployee(Employee employee) {
		return eRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		return eRepository.findByName(name);
	}

	@Override
	public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
		return eRepository.findByNameAndLocation(name, location);
	}

	@Override
	public List<Employee> getEmployeesByKeyword(String keyword) {
		Sort sort=Sort.by(Sort.Direction.ASC, "id");
		return eRepository.findByNameContaining(keyword,sort);
	}

	@Override
	public List<Employee> getEmployeesByNameOrLocation(String name, String location,String anotherLocation) {
		return eRepository.getEmployeesByNameOrLocation(name, location,anotherLocation);
	}

	@Override
	public Integer deleteEmployeeByName(String name) {
		return eRepository.deleteEmployeeByName(name);
	}

}




//private static List<Employee> list=new ArrayList<>();
//
//static {
//	Employee e=new Employee();
//	e.setName("Siddharth");
//	e.setAge(23L);
//	e.setDepartment("Mech");
//	e.setEmail("siddharthdixit@gmail.com");
//	e.setLocation("Delhi");
//	list.add(e);
//	
//	e=new Employee();
//	e.setName("Palash");
//	e.setAge(23L);
//	e.setDepartment("Mech");
//	e.setEmail("palashupadhyay@gmail.com");
//	e.setLocation("Pune");
//	list.add(e);
//}