package CRM.CRM.controller;

import CRM.CRM.model.User;
import CRM.CRM.service.TaskService;
import CRM.CRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersContoller {

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @GetMapping("")
    public String user(){
        return "/users";
    }
    @GetMapping("/{id}")
    public String users(@PathVariable(value = "id") Long id,Model model){

        List<User> users = userService.findAllDeportamentId(id);


        model.addAttribute("users",users);
        return "/users";
    }


    @PostMapping("/users/{id}/delete")
    public String deportamentDelete(@PathVariable(value = "id") Long id){
        userService.deleteUser(id);
            return "redirect:/users";
    }
    @PostMapping("/createTaskUser")
    public String createTaskUser(@RequestParam(name = "username", required = false) String name,
                                 @RequestParam(name = "full_text" , required = false)  String full_text,
                                 @RequestParam(name = "localDateTimeStart" , required = false)String localDateTimeStart,
                                 @RequestParam(name = "localDateTimeEnd" , required = false)String localDateTimeEnd,
                                 @RequestParam(name = "user" , required = false)Long userId,
                                 @RequestParam(name = "priority" , required = false)  String priority) {

        taskService.createTaskUser(name, full_text, localDateTimeStart, localDateTimeEnd,priority, true, userId);
        return "redirect:/users";
    }


    @PostMapping("/{id}/delete")
    public String usersDelete(@PathVariable(value = "id") Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
