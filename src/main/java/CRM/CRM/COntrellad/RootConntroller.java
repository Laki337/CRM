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

        String adres = request.getRequestURI() ;
        System.out.println(adres);
        model.addAttribute("adres", adres);

       model.addAttribute("pr", "peremennaya R");

    }

//ЛОГИРОВАНИЕ
//ERROR



}
