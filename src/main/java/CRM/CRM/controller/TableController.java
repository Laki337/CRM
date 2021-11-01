package CRM.CRM.controller;

import CRM.CRM.model.Deportament;
import CRM.CRM.model.Task;
import CRM.CRM.model.User;
import CRM.CRM.service.DeportamentService;
import CRM.CRM.service.TaskService;
import CRM.CRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/table")
public class TableController {

    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;

    @Autowired
    DeportamentService deportamentService;

    @GetMapping("")
    public String table(Model model) {

        
        Iterable<User> users = userService.findAll();

        Iterable<Deportament> deportaments = deportamentService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("deportaments", deportaments);
        return "/table";
    }


    @PostMapping("/createTaskDeportament")
    public String createTaskDeportament(@RequestParam(name = "username", required = false) String name,
                                        @RequestParam(name = "full_text" , required = false)  String full_text,
                                        @RequestParam(name = "localDateTimeStart" , required = false)String localDateTimeStart,
                                        @RequestParam(name = "localDateTimeEnd" , required = false)String localDateTimeEnd,
                                        @RequestParam(name = "deportamentId" , required = false)Long deportamentId,
                                        @RequestParam(name = "priority" , required = false)  String priority
    ) {

        taskService.createTaskDeportament(name, full_text, localDateTimeStart, localDateTimeEnd,priority ,deportamentId,  true);

        return "redirect:/table";
    }
    @PostMapping ("/updateDeportament")
    public String updateDepartament(Long idDepartament, String nameDepartament){
        Deportament deportament = deportamentService.find(idDepartament);
        deportamentService.update(deportament,nameDepartament);
        return "redirect:/table";

    }

    @PostMapping("/{id}/delete")
    public String deportamentDelete(@PathVariable(value = "id") Long id){

        deportamentService.deleteDeportament(id);
        return "redirect:/table";
    }
}
