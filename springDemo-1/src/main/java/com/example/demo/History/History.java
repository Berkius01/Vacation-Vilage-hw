package com.example.demo.History;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name="history_view")
public class History {
	@Id
	@SequenceGenerator(
			name="history_sequance",
			sequenceName="history_sequance",
			allocationSize=1
	)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="history_sequance"
	)
	@Column(name = "hid")
	public Long hid;
	@Column(name = "activity_type")
	public String activityType;
	@Column(name = "date")
	public String Date;
	@Column(name = "hour")
	public String Hour;
	@Column(name = "name")
	public String Name;//ortak
	@Column(name = "internet")
	public String Internet;//ortak
	@Column(name = "capacity")
	public String Capacity;
	@Column(name = "age")
	public String Age;
	@Column(name = "animator_id")
	public String AnimatorId;
	
	
	
	public History(String activityType, String date, String hour, String name, String internet, String capacity,
			String age, String animatorId) {
		//super();
		this.activityType = activityType;
		Date = date;
		Hour = hour;
		Name = name;
		Internet = internet;
		Capacity = capacity;
		Age = age;
		AnimatorId = animatorId;
	}
	
	
	public History() {
		
	}


	public Long getHid() {
		return hid;
	}
	public void setHid(Long hid) {
		this.hid = hid;
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
		Date = date;
	}
	public String getHour() {
		return Hour;
	}
	public void setHour(String hour) {
		Hour = hour;
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
	public String getAnimatorId() {
		return AnimatorId;
	}
	public void setAnimatorId(String animatorId) {
		AnimatorId = animatorId;
	}
	
	
	
	
}
