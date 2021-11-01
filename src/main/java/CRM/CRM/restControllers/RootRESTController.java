package CRM.CRM.restControllers;


import CRM.CRM.model.Deportament;
import CRM.CRM.model.Event;
import CRM.CRM.model.User;
import CRM.CRM.repository.EventRepository;
import CRM.CRM.service.DeportamentService;
import CRM.CRM.service.EventService;
import CRM.CRM.service.TaskService;
import CRM.CRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController

@RequestMapping("/get")
public class RootRESTController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    DeportamentService deportamentService;
    
    @Autowired
    EventService eventService;
    
    @Autowired
    TaskService taskService;
    
    @RequestMapping("/users/{depo}")
    public List<User> getAllDepartment(@PathVariable(value = "depo") String depo) {
        System.err.println("RAZ");
        Deportament deportament = deportamentService.findByName(depo);
    
        //     userService.findAllDeportamentId(deportament.getId());
    
    
        return userService.findAllDeportamentId(deportament.getId());
    }
    
    @RequestMapping("/dela/{month}/{year}")
    public List<Event> getAllEvent(@PathVariable(value = "month") Long month, @PathVariable(value = "year") String year) {
        List<Event> list = eventService.findByAllDateStartBetween(year + "-" + month + '-' + "-00", year + "-" + (month + 1) + '-' + "-00", 1L);
        return list;
    }
    
    @RequestMapping("/departments")
    public List<Deportament> getAllDepartment() {
        System.err.println("DVA");
        List<Deportament> list = deportamentService.findAll();
        return list;
    }
    
    @RequestMapping("/createTaskUser")
    public String createTaskUser(@RequestParam(name = "username", required = false) String name,
                                 @RequestParam(name = "text", required = false) String full_text,
                                 @RequestParam(name = "dataStart", required = false) String localDateTimeStart,
                                 @RequestParam(name = "dataEnd", required = false) String localDateTimeEnd,
                                 @RequestParam(name = "userId", required = false) Long userId,
                                 @RequestParam(name = "priority", required = false) String priority) {
        System.err.println("TTYYTT");
        taskService.createTaskUser(name, full_text, localDateTimeStart, localDateTimeEnd, priority, true, userId);
        
        return "redirect:/table";
        
    }
}
