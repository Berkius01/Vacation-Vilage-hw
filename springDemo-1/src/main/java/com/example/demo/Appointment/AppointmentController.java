package com.example.demo.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping(path= "api/v1/appointment",method= {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})
public class AppointmentController {
	
	private final AppointmentService appointmentService;
	@Autowired
	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService=appointmentService;
	}
	
	@GetMapping(path="get")
	public ModelAndView getAppointment(){
		ModelAndView mav = new ModelAndView("list-appointment");
		mav.addObject("App",appointmentService.getApp());
		return mav;
	}
	
	@PostMapping(path="{id}/{aid}/{type}/{name}")
	public ModelAndView addAnimator(@PathVariable("id") String id,@PathVariable("aid") String aid,@PathVariable("type") String type,@PathVariable("name") String name) 
	{
		Appointment app = new Appointment(id,aid,type,name);
		appointmentService.addNewAppointment(app);
		String url="redirect:/api/v1/mass/listmass/"+id;
		return new ModelAndView(url);
	}
}
