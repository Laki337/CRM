package CRM.CRM.controller;

import CRM.CRM.model.User;
import CRM.CRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("")
public class  RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String regPage(){

        return "registration";
    }

    @PostMapping("/registration")
    public String userAdd(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String email) {

        userService.createUser(username, password, email);
        return "registration";

    }
    @PostMapping("/changePassword")
    public String changePassword(String email){

   User user = userService.checkEmail(email);
   if(user!=null){
       user.setCod(UUID.randomUUID().toString());
   }

        return "changePassword2";
    }
}
