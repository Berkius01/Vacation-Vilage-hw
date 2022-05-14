package com.example.demo.Mass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Mass {
	@Id
	@SequenceGenerator(
			name="mass_sequence",
			sequenceName="mass_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "mass_sequence"
	)
	
	public Long ID;//ikisine ortak
	public String activityType;
	public String Date;
	public String Hour;
	public String Name;//ortak
	public String Internet;//ortak
	public String Capacity;
	public String Age;
	public String AnimatorPhone;
	
	public Mass(String activityType, String date, String hour, String name, String internet, String capacity,
			String age, String animatorPhone) {
		
		this.activityType = activityType;
		this.Date = date;
		this.Hour = hour;
		this.Name = name;
		this.Internet = internet;
		this.Capacity = capacity;
		this.Age = age;
		
	}


	
	
	
	public Long getID() {
		return ID;
	}





	public void setID(Long iD) {
		ID = iD;
	}





	public String getName() {
		return Name;
	}





	public void setName(String name) {
		Name = name;
	}





	public String getInternet() {
		return Internet;
	}





	public void setInternet(String internet) {
		Internet = internet;
	}





	public String getCapacity() {
		return Capacity;
	}





	public void setCapacity(String capacity) {
		Capacity = capacity;
	}





	public String getAge() {
		return Age;
	}





	public void setAge(String age) {
		Age = age;
	}





	public String getAnimatorPhone() {
		return AnimatorPhone;
	}





	public void setAnimatorPhone(String animatorPhone) {
		AnimatorPhone = animatorPhone;
	}





	public Mass() {
		
	}
	

	
	
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		this.Date = date;
	}
	public String getHour() {
		return Hour;
	}
	public void setHour(String hour) {
		this.Hour = hour;
	}
	
	
	
	
}
