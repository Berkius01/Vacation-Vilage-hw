package com.example.demo.Animator;

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

import com.example.demo.Customer.Customer;

@RestController
@RequestMapping(path= "api/v1/animator",method= {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})
public class AnimatorController {
	
	private final AnimatorService animatorService;
	@Autowired
	public AnimatorController(AnimatorService animatorService) {
		this.animatorService=animatorService;
	}
	
	@GetMapping(path="get")
	public ModelAndView getAnimator()
	{
		ModelAndView mav = new ModelAndView("list-animators");
		mav.addObject("Animator",animatorService.getAnimator());
		
		return mav;
	}
	
	@DeleteMapping(path = "{EmployeeId}")
	public ModelAndView deleteAnimaotr(@PathVariable("EmployeeId") Long EmployeeId) {
		animatorService.deleteAnimator(EmployeeId);
		return new ModelAndView("redirect:/api/v1/animator/get");
	}
	@PostMapping(path= "postindex")
	public ModelAndView addAnimator() {
		ModelAndView mav1 = new ModelAndView("addAnimator");
		return mav1;
	}
	
	@PostMapping(path="post", params= {"add"})
	public ModelAndView addAnimator(Animator animator) {
		
		animatorService.addNewAnimator(animator);
		return new ModelAndView("redirect:/api/v1/animator/get");
	}
	
	@GetMapping(path="loginindex")
	public ModelAndView loginAnimator() {
		//customerService.addNewCustomer(customer);
		return new ModelAndView("animatorLogin");
	}
	@GetMapping(path="log", params= {"login"})
	public ModelAndView loginCustomer(Animator animator) {
		//customerService.addNewCustomer(customer);
		int flag = animatorService.valid(animator);
		if(flag!=0) {
			ModelAndView mav = new ModelAndView("animatorindex");
			mav.addObject("id",flag);
			return mav;
		}
		/*else if(flag == 2) {
			return new ModelAndView("admin");
		}*/
		else {
			return new ModelAndView("redirect:http://localhost:8080");
		}
		
	}
	
}
