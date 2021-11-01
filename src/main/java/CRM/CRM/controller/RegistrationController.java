package CRM.CRM.controller;

import CRM.CRM.model.User;
import CRM.CRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
@RequestMapping("")
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping("/changePassword")
    public String pas() {
        return "changePassword";
    }
    
    @GetMapping("/login")
    public String login() {
        return "/login";
    }
    
    @PostMapping("/changePassword")
    public String changePassword(String email) {

        User user = userService.findEmail(email);
        if (user != null) {
            user.setCod(UUID.randomUUID().toString());
            userService.saveUser(user);
        }

        return "changePassword";
    }

    @GetMapping("/changePassword/{code}")
    public String changePassworddddd(@PathVariable("code") String code, Model model) {
        model.addAttribute("tok", code);
        return "changePassword2";


    }
    

    @PostMapping("/changePassword/{id}")
    public String newPassword(@PathVariable(value = "id") Long id, String password) {
        User user = userService.findUserId(id);
        user.setPassword(password);
        user.setCod("");
        userService.saveUser(user);
        return "login";
    }
}
