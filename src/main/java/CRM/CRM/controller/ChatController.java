package CRM.CRM.controller;

import CRM.CRM.model.Message;
import CRM.CRM.repository.ChatRepository;
import CRM.CRM.service.ChatService;
import CRM.CRM.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;


@Controller

public class ChatController {
    @Autowired
    MessageService messageService;
    
    @Autowired
    ChatService chatService;
    
    

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting( Message message)  {
     // final   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
     // final  User user = (User) auth.getPrincipal();
        System.err.println("RAZ");
        chatService.chatAddUser(chatService.chatSave("Название",new Date()).getId(),5L);
      //  messageService.create(anons, message, 1L, id )
        
        return message;
    }
    

    @GetMapping("/lc")
    public String allTask(Model model) {

        List<Message> messages = messageService.findAll();
        model.addAttribute("messages", messages);
        model.addAttribute("data", new Date());

        return "lc";
    }
    
    @GetMapping("/chat/{id}")
    public String chat(Model model) {
        
        
        return "chat";
    }


}
