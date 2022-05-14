package com.example.demo.History;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path="api/v1/history",method= {RequestMethod.GET})
public class HistoryController {
	
	private final HistoryRepository historyRepo;
	@Autowired
	public HistoryController(HistoryRepository historyRepo) {
		this.historyRepo=historyRepo;
	}
	@GetMapping(path="get")
	public ModelAndView getHistory() {
		ModelAndView mav = new ModelAndView("list-history");
		mav.addObject("history",historyRepo.findAll());
		return mav;
	}
}
