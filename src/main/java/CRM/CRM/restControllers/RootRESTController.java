package CRM.CRM.restControllers;


import CRM.CRM.model.User;
import CRM.CRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/get")
public class RootRESTController {

    @Autowired
    UserService userService;


    @RequestMapping("/users")
    public List<User> getAllUser() {
        List<User> list = userService.findAll();
        for (User user : list) {

            System.err.println(" ZASHLI!");
            System.out.println(userService.findAll().toString());
            return userService.findAll();


        }


            return list;
    }
}
