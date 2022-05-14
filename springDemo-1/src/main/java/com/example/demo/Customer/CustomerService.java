package com.example.demo.Customer;

import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> getCustomer()
	{
		return customerRepository.findAll();
	}
	
	public void deleteCustomer(Long VacationVillageID) {
		boolean exists = customerRepository.existsById(VacationVillageID);
		if(!exists) {
			throw new IllegalStateException("customer doesn't exists");
		}
		customerRepository.deleteById(VacationVillageID);
	}
	
	public void addNewCustomer(Customer customer) {
		/*Optional<Customer> customerByID=customerRepository.findCustomerByID(customer.getVacationVillageId());
		if(customerByID.isPresent()) {
			throw new IllegalStateException("customer also registered");
		}*/
		//else {
		if(customer.getContactPhone().equals("admin")){
			customer.setPassword("admin");
			customerRepository.save(customer);
		}
		else{
			customer.setPassword(generateRandomPassword());
			customerRepository.save(customer);
		}
		
			
		//}
	}
	public int valid(Customer customer) {
		Customer customerDb = customerRepository.findCustomerByPhoneAndPassword(customer.getContactPhone(), customer.getPassword()).orElseThrow(()->new IllegalStateException());
		/*System.out.println(customerDb.getContactPhone()+" "+ customerDb.getPassword());
		System.out.println(customer.getContactPhone()+" "+ customer.getPassword());*/
        if(customerDb.getContactPhone().equals("admin") && customerDb.getPassword().equals("admin")) {
        	System.out.println("admin geldi");
        	return 2;
        } 
        else if(customerDb.getContactPhone().equals(customer.getContactPhone()) && customerDb.getPassword().equals(customer.getPassword())) {
        	//System.out.println("müşteri geldi");
        	return Integer.parseInt((customerDb.getVacationVillageId()).toString());
        } 
        /*else {
        	System.out.println(customerDb.getContactPhone()+" "+ customerDb.getPassword());
    		System.out.println(customer.getContactPhone()+" "+ customer.getPassword());*/
        	return 0;
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

	public Customer getById(Customer customer) {
		//Customer customerDb = customerRepository.findCustomerByPhoneAndPassword(customer.getContactPhone(), customer.getPassword()).orElseThrow(()->new IllegalStateException());
		Customer customerDb = customerRepository.findCustomerByID(customer.getVacationVillageId()).orElseThrow(()->new IllegalStateException());
		//customerRepository.getById(customer.getVacationVillageId());
		return customerDb;
	}

	

	
}
