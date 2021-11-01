package CRM.CRM.controller;

import CRM.CRM.model.Deportament;
import CRM.CRM.model.User;
import CRM.CRM.service.DeportamentService;
import CRM.CRM.service.TaskService;
import CRM.CRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/form")
public class FormController {
    @Autowired
    DeportamentService deportamentService;

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @GetMapping("")
    public String getForm(Model model) {

        final Iterable<Deportament> deportaments = deportamentService.findAll();
        final Iterable<User> users = userService.findAll();

        model.addAttribute("deportaments", deportaments);
        model.addAttribute("users", users);
        return "form";
    }

    @PostMapping("/createDeportament")
    public String createDeportament(String name) {
        deportamentService.createDeportament(name);
        return "redirect:/form";
    }

    @PostMapping("/reg")
    public String userAdd(@RequestParam(name = "username", required = false) String username,
                          @RequestParam(name = "lastname", required = false) String lastname,
                          @RequestParam(name = "login", required = false) String login,
                          @RequestParam(name = "password", required = false) String password,
                          @RequestParam(name = "number", required = false) String phone,
                          @RequestParam(name = "email", required = false) String email,
                          @RequestParam(name = "deportament") String deportament,
                          Model model, HttpServletRequest request) {
       final User user = userService.createUser(username, lastname, login, password, phone, email, deportament);
       if(user.getId()!=null) {
           final HttpSession session = request.getSession();
           session.setAttribute("otvet_sistemi", userService.createUser(username, lastname, login, password, phone, email, deportament));
           model.addAttribute("otvet_sistemi", userService.createUser(username, lastname, login, password, phone, email, deportament));
       }
        return "redirect:/form";

    }

    @PostMapping("/createTaskUser")
    public String createTaskUser(@RequestParam(name = "username", required = false) String name,
                                 @RequestParam(name = "full_text", required = false) String full_text,
                                 @RequestParam(name = "localDateTimeStart", required = false) String localDateTimeStart,
                                 @RequestParam(name = "localDateTimeEnd", required = false) String localDateTimeEnd,
                                 @RequestParam(name = "deportament", required = false) Long departamentId,
                                 @RequestParam(name = "user", required = false) Long userId,
                                 @RequestParam(name = "priority", required = false) String priority) {

        taskService.createTaskUser(name, full_text, localDateTimeStart, localDateTimeEnd, priority, true, userId);

        return "redirect:/form";
    }
}
