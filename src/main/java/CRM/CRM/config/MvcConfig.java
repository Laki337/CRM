package CRM.CRM.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/main").setViewName("index");
        registry.addViewController("/CreateDeportament").setViewName("CreateDeportament");
        registry.addViewController("/gallery").setViewName("gallery");
        registry.addViewController("/chart").setViewName("chart");
        registry.addViewController("/lc").setViewName("lc");
        registry.addViewController("/tasks").setViewName("tasks");
        registry.addViewController("/messages").setViewName("messages");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/calendar").setViewName("calendar");
        registry.addViewController("/error").setViewName("error");




    }
}