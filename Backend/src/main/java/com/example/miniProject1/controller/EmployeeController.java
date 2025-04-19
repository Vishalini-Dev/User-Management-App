package com.example.miniProject1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.miniProject1.model.Employee;
import com.example.miniProject1.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class EmployeeController {
	EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@GetMapping("users")
	public List<Employee> allUserDetails(){
		return employeeService.allUserDetails();
	}
	
	@GetMapping("users/{sno}")
	public Optional<Employee> userDetails(@PathVariable int sno) {
		return employeeService.userDetails(sno);
	}
	
	
	@PostMapping("users/add")
	public String addDetails(@RequestParam("fName") String fName,
	                         @RequestParam("lName") String lName,
	                         @RequestParam("emailId") String emailId,
	                         @RequestParam("phoneNo") String phoneNo) {
	    employeeService.addDetails(fName, lName, emailId, phoneNo);
	    return "Employee details added successfully";
	}

	
	@PutMapping("users/update")
	public Employee updateDetails( @RequestParam int sno,
	        @RequestParam String fName,
	        @RequestParam String lName,
	        @RequestParam String emailId,
	        @RequestParam String  phoneNo ) {
		
		return employeeService.updateDetails( sno,  fName,  lName, emailId, phoneNo);
		}
	
	@DeleteMapping("users/{sno}")
	public String deleteDetails(@PathVariable int sno) {
		employeeService.deleteDetails(sno);
		return "Emplyee details deleted successfully"; 
	}
	
}
