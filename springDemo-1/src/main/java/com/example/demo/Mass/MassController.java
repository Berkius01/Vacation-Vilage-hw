package com.example.demo.Mass;

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
@RequestMapping(path= "api/v1/mass",method= {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})
public class MassController {
	
	private final MassService massService;
	@Autowired
	public MassController(MassService massService) {
		this.massService=massService;
	}
	
	@GetMapping(path="get/{id}")
	public ModelAndView getMass(@PathVariable("id") int aid)
	{
		ModelAndView mav = new ModelAndView("list-mass");
		mav.addObject("Mass",massService.getMass());
		mav.addObject("id",aid);
		return mav;
	}
	
	@GetMapping(path="get")
	public ModelAndView getMass()
	{
		ModelAndView mav = new ModelAndView("list-massAdmin");
		mav.addObject("Mass",massService.getMass());
		
		return mav;
	}
	
	@GetMapping(path="listmass/{variable}")
	public ModelAndView getMassForCustomer(@PathVariable("variable") String cphone)
	{
		ModelAndView mav = new ModelAndView("list-massCustomer");
		mav.addObject("Mass",massService.getMass());
		mav.addObject("phone",cphone);
		return mav;
	}
	
	@GetMapping(path="listmass")
	public ModelAndView getMassForCustomer()
	{
		ModelAndView mav = new ModelAndView("list-massCustomer");
		mav.addObject("Mass",massService.getMass());
	
		return mav;
	}
	
	@DeleteMapping(path = "{EmployeeId}/{animatorId}")
	public ModelAndView deleteMass(@PathVariable("EmployeeId") Long EmployeeId,@PathVariable("animatorId") int id) {
		massService.deleteMass(EmployeeId);
		String url = "redirect:/api/v1/mass/get/"+id;
		return new ModelAndView(url);
	}
	
	@PostMapping(path= "get/postindex/{id}")
	public ModelAndView addMass(@PathVariable("id") int aid) {
		ModelAndView mav1 = new ModelAndView("addMass");
		mav1.addObject("id",aid);
		return mav1;
	}
	
	@PostMapping(path="get/postindex/post/{id}", params= {"add"})
	public ModelAndView addMass(Mass mass,@PathVariable("id") int aid) {
		//System.out.println(mass.getAnimatorPhone()+"+"+mass.getInternet());
		
		mass.setAnimatorPhone(String.valueOf(aid));
		massService.addNewMass(mass);
		String url = "redirect:/api/v1/mass/get/"+aid;
		return new ModelAndView(url);
	}
	
	
		
	
	
}
