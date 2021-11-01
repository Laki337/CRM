package CRM.CRM.controller;

import CRM.CRM.model.User;
import CRM.CRM.repository.MessageRepository;
import CRM.CRM.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("messages")
@Controller
public class MessagesController {
	
	@Autowired
	MessageService messageService;
	
	
	@GetMapping("")
	public String getMessages(Model model){
		
	//	final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	//	final User user = (User) auth.getPrincipal();

		System.err.println(messageService.findMessage(5L, 5L));
		model.addAttribute(messageService.findMessage(5L, 5L));

		
		return "messages";
	}
}
