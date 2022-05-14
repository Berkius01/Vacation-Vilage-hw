package com.example.demo.Appointment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AppointmentService {
	
	private final AppointmentRepository appointmentRepository;
	@Autowired
	public AppointmentService(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}
	
	
	public void addNewAppointment(Appointment app) {
		// TODO Auto-generated method stub
		appointmentRepository.save(app);
		
	}


	public List<Appointment> getApp() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}
}
