package CRM.CRM.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/AllTask").setViewName("AllTask");
        registry.addViewController("/AllUser").setViewName("AllUser");
        registry.addViewController("/CreateDeportament").setViewName("CreateDeportament");
        registry.addViewController("/CreateTask").setViewName("CreateTask");
        registry.addViewController("/CreateUser").setViewName("CreateUser");
        registry.addViewController("/DeleteDeportament").setViewName("DeleteDeportament");
        registry.addViewController("/DeleteTask").setViewName("DeleteTask");
        registry.addViewController("/DeleteUser").setViewName("DeleteUser");
        registry.addViewController("/UpdateDeportament").setViewName("UpdateDeportament");
        registry.addViewController("/UpdateTask").setViewName("UpdateTask");
        registry.addViewController("/UpdateUser").setViewName("UpdateUser");


    }
}