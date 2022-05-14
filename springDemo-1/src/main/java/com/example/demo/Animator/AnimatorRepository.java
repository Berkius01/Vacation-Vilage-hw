package com.example.demo.Animator;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Customer.Customer;

@Repository
public interface AnimatorRepository extends JpaRepository<Animator,Long>{
	
	@Query("SELECT a FROM Animator a WHERE a.PhoneNumber = ?1 AND a.Password = ?2")
    Optional<Animator> findAnimatorByPhoneAndPassword(String ContactPhone,String Password);
}
