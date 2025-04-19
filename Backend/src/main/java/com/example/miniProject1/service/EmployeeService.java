package com.example.miniProject1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.miniProject1.model.Employee;
import com.example.miniProject1.repository.EmployeeRepository;
@Service
public class EmployeeService {
	
	EmployeeRepository employeeRepo;

	public EmployeeService(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	public Optional<Employee> userDetails(int sno) {
		return employeeRepo.findById(sno);
	}

	public void addDetails( String fName, String lName, String emailId, String  phoneNo) {
		if (!phoneNo.matches("\\d{10}")) {
	         ResponseEntity.badRequest().body("❌ Phone number must be exactly 10 digits.");
	         return;
	    }
		Employee emp =new Employee(fName,lName,emailId,phoneNo);
		employeeRepo.save(emp);
		
	}

	public Employee updateDetails( int sno, String fName, String lName, String emailId, String  phoneNo) {
		Optional<Employee> existing = employeeRepo.findById(sno);
        if (existing.isPresent()) {
            Employee user = existing.get();
            user.setfName(fName);
            user.setlName(lName);
            user.setEmailId(emailId);
            user.setPhoneNo(phoneNo);
            return employeeRepo.save(user);
        }
        return null;
	}

	public List<Employee> allUserDetails() {
		return employeeRepo.findAll();
	}

	public void deleteDetails(int sno) {
		employeeRepo.deleteById(sno);
	}
	
	

}
