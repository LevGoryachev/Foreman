package ru.goryachev.foreman.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.goryachev.foreman.service.ConstructionService;

@Configuration
public class ServiceConfig implements WebMvcConfigurer {

    @Bean
    public ConstructionService getConstructionService () {
        return new ConstructionService();
    }


}
