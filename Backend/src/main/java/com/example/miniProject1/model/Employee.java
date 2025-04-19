package com.example.miniProject1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;



@Entity
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;

    @NotBlank(message = "First name is required")
    private String fName;

    @NotBlank(message = "Last name is required")
    private String lName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String emailId;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
    private String phoneNo;
	 

	

	public Employee(int sno, String fName, String lName, String emailId, String phoneNo) {
		this.sno = sno;
		this.fName = fName;
		this.lName = lName;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}

	public Employee( String fName, String lName, String emailId, String  phoneNo) {
		this.fName = fName;
		this.lName = lName;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}
	
	
	public Employee() {
	}

	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String  getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String  phoneNo) {
		this.phoneNo = phoneNo;
	}
}
	 

