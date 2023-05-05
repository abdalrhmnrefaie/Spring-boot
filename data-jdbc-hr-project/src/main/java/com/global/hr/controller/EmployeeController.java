package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeController(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

// Count of Employee
	@GetMapping("/count")
	public Long countEmp() {

		return employeeRepo.count();

	}

//	Search by Id
	@GetMapping("/{id}")
	public Employee FindById(@PathVariable Long id) {

		return employeeRepo.findById(id).get();

	}

	@GetMapping("/")
	public List<Employee> FindAll() {

		return (List<Employee>) employeeRepo.findAll();

	}

//	Insert
	@GetMapping("/insert")
	public Employee addEmp() {

		return employeeRepo.save(new Employee(null, "Ali", 805080.0));

	}

	@PostMapping("")
	public Employee addEmp(@RequestBody Employee emp) {

		return employeeRepo.save(emp);

	}

//	Update
	@GetMapping("/update")
	public Employee update() {

		return employeeRepo.save(new Employee(42L, "Abdalrhmn", 606060.0));

	}

	@PutMapping("")
	public Employee update(@RequestBody Employee emp) {

		return employeeRepo.save(emp);

	}

//	search by name
	@GetMapping("/filter/{name}")
	public List<Employee> filter(@PathVariable String name) {

		return employeeRepo.findByName(name);

	}

//	Delete
	@DeleteMapping("/{id}")
	public void deleteEmp(@PathVariable Long id) {

		employeeRepo.deleteById(id);

	}

/*
	  public void testJackson() throws JsonMappingException,
	  JsonProcessingException {
	  
	  ObjectMapper mapper= new ObjectMapper();
	  
	  String JsonString = "{\r\n" + "   \"employeeId\": 20,\r\n" +
	  "   \"name\": \"abdalrhmn\",\r\n" + "  \"salary\": 101010.0 \r\n" +"      }";
	  
	  Employee employee=mapper.readValue(JsonString,Employee.class );
	  
	  JsonString
	  =mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
	  
	  }
	  
	  
*/  

}
