package com.example.demo.Appointment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Appointment {
	
	@Id
	@SequenceGenerator(
			name="app_sequence",
			sequenceName="app_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "app_sequence"
	)
	
	public Long ID;//ikisine ortak
	public String AnimatorPhone;
	public String CustomerPhone;
	public String ActivityType;
	public String Name;
	
	public Appointment(String animatorPhone, String customerPhone, String activityType, String name) {
		//super();
		AnimatorPhone = animatorPhone;
		CustomerPhone = customerPhone;
		ActivityType = activityType;
		Name = name;
	}
	
	public Appointment() {
		//super();
	}

	public Appointment(String animatorPhone, String activityType, String name) {
		
		AnimatorPhone = animatorPhone;
		ActivityType = activityType;
		Name = name;
	}

	public Appointment(String animatorPhone, String customerPhone) {
		
		AnimatorPhone = animatorPhone;
		CustomerPhone = customerPhone;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getAnimatorPhone() {
		return AnimatorPhone;
	}

	public void setAnimatorPhone(String animatorPhone) {
		AnimatorPhone = animatorPhone;
	}

	public String getCustomerPhone() {
		return CustomerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		CustomerPhone = customerPhone;
	}

	public String getActivityType() {
		return ActivityType;
	}

	public void setActivityType(String activityType) {
		ActivityType = activityType;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	
	
	
}
