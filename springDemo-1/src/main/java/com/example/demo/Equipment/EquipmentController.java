package com.example.demo.Equipment;


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
@RequestMapping(path="api/v1/equipment",method= {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
public class EquipmentController {
	private final EquipmentService eqService;
	@Autowired
	public EquipmentController(EquipmentService eqService) {
		this.eqService=eqService;
	}
	
	@GetMapping(path="get")
	public ModelAndView getEquipment() {
		ModelAndView mav = new ModelAndView("list-eq");
		mav.addObject("Equipment",eqService.getEq());
		return mav;
	}
	
	@GetMapping(path="geta")
	public ModelAndView getEquipment2() {
		ModelAndView mav = new ModelAndView("list-equAnimator");
		mav.addObject("Equipment",eqService.getEq());
		return mav;
	}
	
	
	@DeleteMapping(path="del/{eid}")
	public ModelAndView delEquipment(@PathVariable("eid")Long id) {
		eqService.deleteEq(id);
		ModelAndView mav = new ModelAndView("list-eq");
		mav.addObject("Equipment",eqService.getEq());
		return mav;
	}
	@GetMapping(path="postindex")
	public ModelAndView addEquipment(){
		ModelAndView mav = new ModelAndView("addEquipment");
		return mav;
	}
	
	@PostMapping(path="post")
	public ModelAndView addEquipment(Equipment eq) {
		eqService.addEq(eq); 
		ModelAndView mav = new ModelAndView("list-eq");
		mav.addObject("Equipment",eqService.getEq());
		return mav;
	}
	
	
	
	
	
	
}
