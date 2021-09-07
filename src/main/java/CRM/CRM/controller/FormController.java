package CRM.CRM.controller;

import CRM.CRM.model.Deportament;
import CRM.CRM.model.User;
import CRM.CRM.service.DeportamentService;
import CRM.CRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.logging.Logger;

@Controller
@RequestMapping("/form")
public class FormController {
    private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    DeportamentService deportamentService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getForm(Model model){
        Iterable<Deportament> deportaments = deportamentService.findAll();
        model.addAttribute("deportaments",deportaments);
        Iterable<User> users = userService.findAll();
        System.out.println("SSSS");
        model.addAttribute("users",users);
        return "form";
    }
    @PostMapping("/createDeportament")
    public String createDeportament(String name){
        System.out.println("AAAA");
        Deportament deportament = new Deportament(name, new Date());
        LOGGER.info("Создан отдел");
        deportamentService.createDepartament(deportament);
        return "form";
    }
    @PostMapping("/reg")
    public String userAdd(@RequestParam(name = "username", required = false) String username,
                          @RequestParam(name = "lastname", required = false) String lastname,
                          @RequestParam(name = "login", required = false) String login,
                          @RequestParam(name = "password", required = false) String password,
                          @RequestParam(name = "number", required = false) String phone,
                          @RequestParam(name = "email", required = false) String email,
                          @RequestParam(name = "deportament", defaultValue = "chto to") String deportament,
                          Model model) {
        if (username == null)
        model.addAttribute("otvet_sistemi", userService.createUser(username, lastname, login, password, phone, email, deportament));

        return "form";

    }
}
