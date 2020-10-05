package ru.goryachev.foreman.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.goryachev.foreman.service.PartBean;

@Configuration
public class SpringConfig {

    @Bean
    public PartBean getPartBean () {
        return new PartBean("Foreman: test page");
    }

}
