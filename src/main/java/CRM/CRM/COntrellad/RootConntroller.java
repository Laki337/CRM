package CRM.CRM.COntrellad;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RootConntroller {

    @ModelAttribute
    public void doit(HttpServletRequest request, Model model){

        StringBuffer adres = request.getRequestURL();
        System.out.println(request.getRequestURL().toString());
        model.addAttribute("adres", adres);

       model.addAttribute("pr", "peremennaya R");

    }

//ЛОГИРОВАНИЕ
//ERROR



}
