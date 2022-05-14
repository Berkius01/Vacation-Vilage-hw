package com.example.demo.Animator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Animator {	
	
	@Id
	@SequenceGenerator(
			name="animator_sequence",
			sequenceName="animator_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "animator_sequence"
	)
	
	
	private Long EmployeeID;
	private String Name;
	private String PhoneNumber;
	private String ExpertiseArea;
	private String Password;
	
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	public Long getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(Long employeeID) {
		this.EmployeeID = employeeID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}
	public String getExpertiseArea() {
		return ExpertiseArea;
	}
	public void setExpertiseArea(String expertiseArea) {
		this.ExpertiseArea = expertiseArea;
	}
	public Animator(Long employeeID, String name, String phoneNumber, String expertiseArea) {
		
		this.EmployeeID = employeeID;
		this.Name = name;
		this.PhoneNumber = phoneNumber;
		this.ExpertiseArea = expertiseArea;
	}
	public Animator(String name, String phoneNumber, String expertiseArea) {
		
		this.Name = name;
		this.PhoneNumber = phoneNumber;
		this.ExpertiseArea = expertiseArea;
	}
	public Animator() {
		
	}
	public Animator(String phoneNumber, String password) {
		
		this.PhoneNumber = phoneNumber;
		this.Password = password;
	}
	
	
	
	
}
