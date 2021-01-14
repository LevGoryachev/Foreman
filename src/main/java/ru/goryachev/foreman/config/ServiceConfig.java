package ru.goryachev.foreman.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@ComponentScan(basePackages = "ru.goryachev.foreman.service")
public class ServiceConfig implements WebMvcConfigurer {
/*
    //example of use beans
    @Bean
    public ConstructionService getConstructionService () {
        return new ConstructionService();
    }

    @Bean
    public MaterialService getMaterialService () {
        return new MaterialService();
    }

    @Bean
    public BillPositionService getBillPositionService () {
        return new BillPositionService();
    }

    @Bean
    public AppUserService getAppUser () {
        return new AppUserService();
    }

      @Bean
      public RoleService getRoleService () {
        return new RoleService();
    }

    @Bean
    public OrderService getOrderService () {
        return new OrderService();
    }
*/
}
