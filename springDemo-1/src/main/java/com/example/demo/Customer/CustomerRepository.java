package com.example.demo.Customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
	@Query("SELECT c FROM Customer c WHERE c.VacationVillageId=?1")
	Optional<Customer> findCustomerByID(Long vacationVillageID);

	@Query("SELECT c FROM Customer c WHERE c.ContactPhone = ?1 AND c.Password = ?2")
    Optional<Customer> findCustomerByPhoneAndPassword(String ContactPhone,String Password);
}



