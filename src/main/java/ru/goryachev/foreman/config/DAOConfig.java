package ru.goryachev.foreman.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "ru.goryachev.foreman.dao")
public class DAOConfig implements WebMvcConfigurer {
/*
    @Bean
    public ConstructionsDAO getConstructionsDAO () {
        return new ConstructionsDAO();
    }

    @Bean
    public BillPositionDAO getBillPositionDAO () {
        return new BillPositionDAO();
    }

    @Bean
    public MaterialsDAO getMaterialsDAO () {
        return new MaterialsDAO();
    }

    @Bean
    public OrdersDAO getOrdersDAO () {
        return new OrdersDAO();
    }

    @Bean
    public OrderPositionDAO getOrderPositionDAO () {
        return new OrderPositionDAO();
    }

    @Bean
    public AppUsersDAO getUsersDAO () {
        return new AppUsersDAO();
    }

    @Bean
    public RoleDAO getRoleDAO () {
        return new RoleDAO();
    }
    */
}
