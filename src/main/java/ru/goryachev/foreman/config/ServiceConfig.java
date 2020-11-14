package ru.goryachev.foreman.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.goryachev.foreman.service.ConstructionService;
import ru.goryachev.foreman.service.MaterialService;

@Configuration
public class ServiceConfig implements WebMvcConfigurer {

    @Bean
    public ConstructionService getConstructionService () {
        return new ConstructionService();
    }

    @Bean
    public MaterialService getMaterialService () {
        return new MaterialService();
    }


}
