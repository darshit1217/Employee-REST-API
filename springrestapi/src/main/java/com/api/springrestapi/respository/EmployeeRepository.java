package com.api.springrestapi.respository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.springrestapi.model.Employee;

//PagingAndSortingRepository
//JpaRepository<EntityName,DataTypeOfPrimaryKey>
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
//	Jpa finder methods start by naming convention "findBy". Naming convention is important for JPA Finder
	
//	select * from employee where name="Saumya";
	List<Employee> findByName(String name);
	
//	select * from employee where name="Saumya" and location="Bangalore";
	List<Employee> findByNameAndLocation(String name,String location);
	
//	select * from employee where name LIKE "%sh%"
	List<Employee> findByNameContaining(String keyword, Sort sort);
	
//	JPQL -> the method can be given any name , no naming convention needed and you have @Query annotation above the method
	
//	Employee-> The entity name where you used @Entity name
//	(The field name of entity class)<-name= :name->(The argument name in this method)
	@Query("FROM Employee WHERE name= :name OR location= :location OR location= :anotherLocation")
	List<Employee>getEmployeesByNameOrLocation(String name,String location,String anotherLocation);
	
//	For CREATE, UPDATE, DELETE -> void or Integer return type is given
//	For CREATE, UPDATE, DELETE -> @Transactional @Modifying annotation is given
	@Transactional
	@Modifying
	@Query("DELETE FROM Employee WHERE name= :name")
	Integer deleteEmployeeByName(String name);
}
