package CRM.CRM.controller;

import CRM.CRM.model.Deportament;
import CRM.CRM.model.Task;
import CRM.CRM.model.User;
import CRM.CRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserContoller {

    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public String users(@PathVariable(value = "id") Long id,Model model){
        List<User> users = userService.findAll();
        for(User user: users){
            if (user.getDeportamentId()!= id){
                users.remove(user);
            }
        }
        model.addAttribute("users",users);
        return "users";
    }

    @GetMapping("/deportament/{id}")
    public String userss(@PathVariable(value = "id") Long id,Model model){
        List<User> users = userService.findAll();
        for(User user: users){
            if (user.getDeportamentId()!= id){
                users.remove(users);
            }
        }
        model.addAttribute("users",users);
        return "users";
    }
    @PostMapping("/user/{id}/delete")
    public String deportamentDelete(@PathVariable(value = "id") Long id){
        userService.deleteUser(id);
            return "table";
    }
    @RequestMapping("/createUser")
    public String createUser(){
        System.err.println("RAZ");
        return "table";
    }
}
