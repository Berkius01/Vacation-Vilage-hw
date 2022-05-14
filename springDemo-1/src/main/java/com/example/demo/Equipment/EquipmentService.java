package com.example.demo.Equipment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class EquipmentService {
	
	
	
	private final EquipmentRepository eqRepo;
	@Autowired
	public EquipmentService(EquipmentRepository eqRepo) {
		this.eqRepo=eqRepo;
	}
	
	
	
	public List<Equipment> getEq() {
		// TODO Auto-generated method stub
		return eqRepo.findAll();
	}
	
	public void deleteEq(Long eqid) {
		eqRepo.deleteById(eqid);
	}



	public void addEq(Equipment eq) {
		eqRepo.save(eq)		;
	}

}
