package com.api.springrestapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//@Setter
//@Getter
//@ToString

@Entity
//@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="ID")
	private Long id;
	
//	@Column(name="NAME")
	@NotBlank(message="Name should not be null")
	private String name;
//	@Column(name="AGE")
	private Long age=0L;
//	@Column(name="LOCATION")
	private String location;
//	@Column(name="EMAIL")
	@Email(message="Please enter the valid email address")
	private String email;
//	@Column(name="DEPARTMENT")
	@NotBlank(message="Department should not be null")
	private String department;
	
	@CreationTimestamp
	@Column(name="created_at",nullable=false,updatable=false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="update_at")
	private Date updateAt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", location=" + location + ", email=" + email
				+ ", department=" + department + "]";
	}
	
	
}

//@TableGenerator(name="id",initialValue=10000)---> doubt in attributes
// We have use Lombok dependency so no need to 
// create getters and setters, instead we use annotations 
// for them 
