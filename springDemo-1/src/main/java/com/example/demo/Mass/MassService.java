package com.example.demo.Mass;

import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MassService {
	
	private final MassRepository massRepository;
	@Autowired
	public MassService(MassRepository customerRepository) {
		this.massRepository = customerRepository;
	}

	public List<Mass> getMass()
	{
		return massRepository.findAll();
	}
	
	public void deleteMass(Long VacationVillageID) {
		boolean exists = massRepository.existsById(VacationVillageID);
		if(!exists) {
			throw new IllegalStateException("customer doesn't exists");
		}
		massRepository.deleteById(VacationVillageID);
	}
	
	public void addNewMass(Mass mass) {
		/*Optional<Customer> customerByID=customerRepository.findCustomerByID(customer.getVacationVillageId());
		if(customerByID.isPresent()) {
			throw new IllegalStateException("customer also registered");
		}*/
		//else {
		massRepository.save(mass);
		
			
		//}
	}
	
	
	


	

	
}
