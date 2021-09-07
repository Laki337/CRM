package CRM.CRM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/x")
public class IndexController {

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("fignya", "nachenie");
        return "index";
    }
}
