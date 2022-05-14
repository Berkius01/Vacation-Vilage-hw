package com.example.demo.Equipment;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Equipment {
	@Id
	@SequenceGenerator(
			name="eq_sequance",
			sequenceName="eq_sequance",
			allocationSize=1
	)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="eq_sequance"
	)
	private Long eid;
	private String name;
	private String Purpose;
	private String equip_person_ssn;
	private String phone_number;
	private String locker_number;
	
	
	
	
	public Equipment() {
		
	}
	
	public Equipment(String name, String purpose, String equip_person_ssn, String phone_number, String locker_number) {
		
		this.name = name;
		this.Purpose = purpose;
		this.equip_person_ssn = equip_person_ssn;
		this.phone_number = phone_number;
		this.locker_number = locker_number;
	}
	
	
	public Long getEid() {
		return eid;
	}
	public void setEid(Long eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPurpose() {
		return Purpose;
	}
	public void setPurpose(String purpose) {
		Purpose = purpose;
	}
	public String getEquip_person_ssn() {
		return equip_person_ssn;
	}
	public void setEquip_person_ssn(String equip_person_ssn) {
		this.equip_person_ssn = equip_person_ssn;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getLocker_number() {
		return locker_number;
	}
	public void setLocker_number(String locker_number) {
		this.locker_number = locker_number;
	}
	
	
	
}
