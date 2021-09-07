package CRM.CRM.controller;

import CRM.CRM.model.Deportament;
import CRM.CRM.model.Task;
import CRM.CRM.model.User;
import CRM.CRM.service.DeportamentService;
import CRM.CRM.service.TaskService;
import CRM.CRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TableController {

    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;

    @Autowired
    DeportamentService deportamentService;

        @GetMapping("/table")
        public String table(Model model){

            Iterable<Task> tasks = taskService.findAll();
            Iterable<User> users = userService.findAll();
            Iterable<Deportament> deportaments = deportamentService.findAll();
            model.addAttribute("tasks",tasks);
            model.addAttribute("users",users);
            model.addAttribute("deportaments",deportaments);
            return "table";
        }
}
