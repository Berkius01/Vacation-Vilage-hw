package com.example.demo.Animator;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Customer.Customer;



@Service
public class AnimatorService {
	
	private final AnimatorRepository animatorRepository;
	@Autowired
	public AnimatorService(AnimatorRepository animatorRepository) {
		this.animatorRepository = animatorRepository;
	}
	public void addNewAnimator(Animator animator) {
		// TODO Auto-generated method stub
		animator.setPassword(generateRandomPassword());
		animatorRepository.save(animator);
		
	}

	public void deleteAnimator(Long employeeId) {
		boolean exists = animatorRepository.existsById(employeeId);
		if(!exists) {
			throw new IllegalStateException("animator doesn't exists");
		}
		animatorRepository.deleteById(employeeId);
		
	}

	public List<Animator> getAnimator()
	{
		return animatorRepository.findAll();
	}
	
	public int valid(Animator animator) {
		Animator customerDb = animatorRepository.findAnimatorByPhoneAndPassword(animator.getPhoneNumber(), animator.getPassword()).orElseThrow(()->new IllegalStateException());
		/*System.out.println(customerDb.getContactPhone()+" "+ customerDb.getPassword());
		System.out.println(customer.getContactPhone()+" "+ customer.getPassword());*/
        if(customerDb.getPhoneNumber().equals(animator.getPhoneNumber()) && customerDb.getPassword().equals(animator.getPassword())) {
        	System.out.println(customerDb.getEmployeeID().toString());
        	return Integer.parseInt(((customerDb.getEmployeeID()).toString()));
        } 
        /*else {
        	System.out.println(customerDb.getContactPhone()+" "+ customerDb.getPassword());
    		System.out.println(customer.getContactPhone()+" "+ customer.getPassword());*/
        else {
        	return 0;
        }
       
        
       // }
       
			
	}
	
	public String generateRandomPassword()
    {
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance
 
        for (int i = 0; i < 10; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
    }

}
