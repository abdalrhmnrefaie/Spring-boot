package com.global.hr.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("employee")
public class Employee {

	@Id
	@Column("id")
	public Long employeeId;
	private String name;
	private Double Salary;
	
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	} 
	

	public Employee(Long employeeId, String name, Double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		Salary = salary;
	}

	public Long getId() {
		return employeeId;
	}

	public void setId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

}
