package CRM.CRM.controller;


import CRM.CRM.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/calendar")
public class CalendarController {
	
	
	@Autowired
	EventService eventService;
	
	@GetMapping("")
	public String getForm(Model model) {
		
		
		return "calendar";
	}
	
	@PostMapping("/createEvent")
	public String createEvent(String name, Long id, Date dateStart, Date dateEnd, String type) {
		
	
		eventService.createEvent(name, id, dateStart, dateEnd, type);
		return "redirect:/test";
	}
}
