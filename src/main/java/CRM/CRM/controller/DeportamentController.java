package CRM.CRM.controller;

import CRM.CRM.model.Deportament;
import CRM.CRM.model.User;
import CRM.CRM.service.DeportamentService;
import CRM.CRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("")
public class DeportamentController {

    @Autowired
    DeportamentService deportamentService;

    @Autowired
    UserService userService;

    @GetMapping("/deportament")
    public String deportament(){

        return "deportament";
    }
    @PostMapping("/createDeportament")
    public String createDeportament(String name){
        Deportament deportament = new Deportament(name);
        deportamentService.add(deportament);
        return "deportament";
    }
    @PostMapping ("/updateDeportament")
    public String updateDeportament(String name,String newName){
        System.out.println(name);
        Deportament deportament =deportamentService.findByName(name);
        System.out.println(newName);
        deportamentService.update(deportament,newName);
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


    }
    @GetMapping("/AllDeportament")
    public String allDeportament(Model model){
        Iterable<Deportament> deportaments = deportamentService.findAll();
        System.err.println(deportaments.toString());
        model.addAttribute("deportaments",deportaments);
        return "AllDeportament";
    }
}
