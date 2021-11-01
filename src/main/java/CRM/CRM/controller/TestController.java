package CRM.CRM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TestController {
	@GetMapping("/test")
	public String getForm(Model model) {
		
		
		return "test";
	}
	@GetMapping("/react")
	public String react(Model model) {
		
		
		return "/react";
	}

}