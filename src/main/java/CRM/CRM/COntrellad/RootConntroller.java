package CRM.CRM.COntrellad;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RootConntroller {

    @ModelAttribute
    public void doit(HttpServletRequest request, Model model){

       final  StringBuffer adres = request.getRequestURL();
        System.out.println(request.getRequestURL().toString());
        model.addAttribute("adres", adres);

       model.addAttribute("pr", "peremennaya R");

    }

    // Планировщик задач
    //Data
    // Контроль времени
    //chat
    // Авторизация
    // Сохранение картинки в бд
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex)
    {
        System.err.println("ОШИБКА");
        System.err.println(ex.getStackTrace());
        ModelAndView modelAndView = new ModelAndView();
   System.err.println(
                ex.getMessage()
        );
        return modelAndView;
    }
}
