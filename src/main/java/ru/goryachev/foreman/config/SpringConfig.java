package ru.goryachev.foreman.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.goryachev.foreman.service.PartBean;

@Configuration
public class SpringConfig implements WebMvcConfigurer {

    @Bean
    public PartBean getPartBean () {
        return new PartBean("Foreman: test page");
    }

}
