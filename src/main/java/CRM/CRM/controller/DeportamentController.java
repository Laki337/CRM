package CRM.CRM.controller;

import CRM.CRM.model.Deportament;
import CRM.CRM.model.User;
import CRM.CRM.service.DeportamentService;
import CRM.CRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/deportament")
public class DeportamentController {


    @Autowired
    DeportamentService deportamentService;

    @Autowired
    UserService userService;

    @GetMapping("")
    public String deportament(){

        return "deportament";
    }

    @PostMapping ("/deportamentAddUser")
    public void deportamentAddUser(Long id, String name){
       User user = userService.findUserId(id);
        Deportament deportament = deportamentService.findByName(name);
        user.setDeportamentId(deportament.getId());
        userService.saveUser(user);

    }
    @PostMapping ("/deleteDeportament")
    public void deleteDeportament(String name){
      Deportament deportament = deportamentService.findByName(name);
      deportamentService.delete(deportament);

    }

    @GetMapping("/deportament/{id}/update")
    public String getDeportamentUpdate(@PathVariable(value = "id") Long id, Model model){
        Deportament deportament = deportamentService.find(id);
        model.addAttribute("deportaments",deportament);
        return "UpdateDeportament";
    }
    @PostMapping("/deportament/{id}/update")
    public String deportamentUpdate(@PathVariable(value = "id") Long id, String name){
        Deportament deportament = deportamentService.find(id);
        deportament.setName(name);
        deportamentService.createDepartament(deportament);
        return "main";
    }
    @PostMapping("/deportament/{id}/delete")
    public String deportamentDelete(@PathVariable(value = "id") Long id){
        System.err.println("RAZ");
        Deportament deportament = deportamentService.find(id);
        deportamentService.delete(deportament);
        return "table";
    }
}
