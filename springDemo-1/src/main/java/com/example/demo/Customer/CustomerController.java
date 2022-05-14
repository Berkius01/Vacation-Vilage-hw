package com.example.demo.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(path= "api/v1/customer",method= {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})
public class CustomerController {
	
	private final CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}
	
	
	@GetMapping(path="get")
	public ModelAndView getCustomer()
	{
		ModelAndView mav = new ModelAndView("list-customers");
		mav.addObject("Customer",customerService.getCustomer());
		return mav;
	}
	@DeleteMapping(path = "{vacationVillageID}")
	public ModelAndView deleteCustomer(@PathVariable("vacationVillageID") Long VacationVillageId) {
		customerService.deleteCustomer(VacationVillageId);
		return new ModelAndView("redirect:/api/v1/customer/get");
	}
	
	@PostMapping(path= "postindex")						//admin panelinden kullanıcı ekleme sayfası
	public ModelAndView addCustomer() {
		ModelAndView mav1 = new ModelAndView("add");
		return mav1;
	}
	
	
	@PostMapping(path="post", params= {"add"})			// o sayfanın kayıt etmesi	
	public ModelAndView addCustomer(Customer customer) {
		customerService.addNewCustomer(customer);
		return new ModelAndView("redirect:/api/v1/customer/get");
	}
	
	@PostMapping(path= "regindex")							//register sayfasının canlanması için
	public ModelAndView registerCustomer() {
		ModelAndView mav1 = new ModelAndView("register");
		return mav1;
	}
	
	@PostMapping(path="reg", params= {"add"})				//sayfadan gelen verilerin kayıtedilmesi için
	public ModelAndView registerCustomer(Customer customer) {
		customerService.addNewCustomer(customer);
		ModelAndView mav1 = new ModelAndView("customer-index");
		mav1.addObject("Customer", customerService.getById(customer));
		return mav1;
	}
	
	
	@GetMapping(path="loginindex")
	public ModelAndView loginCustomer() {
		//customerService.addNewCustomer(customer);
		return new ModelAndView("login");
	}
	
	@GetMapping(path="log", params= {"login"})
	public ModelAndView loginCustomer(Customer customer) {
		//customerService.addNewCustomer(customer);
		int flag = customerService.valid(customer);
		if(flag!=2) {
			ModelAndView mav = new ModelAndView("customer-index");
			
			mav.addObject("Customer",customer);
			mav.addObject("id",flag);
			return mav;
		}
		else if(flag == 2) {
			return new ModelAndView("admin");
		}
		else {
			return new ModelAndView("redirect:http://localhost:8080");
		}
		
	}
	
	
}