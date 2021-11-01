package CRM.CRM.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class LogerConfig {


    @Bean
    public Logger getLogger(){
        return Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }



}
