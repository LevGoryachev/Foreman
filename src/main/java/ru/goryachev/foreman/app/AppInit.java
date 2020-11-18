package ru.goryachev.foreman.app;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.goryachev.foreman.config.DAOConfig;
import ru.goryachev.foreman.config.JdbcConfigSample;
import ru.goryachev.foreman.config.ServiceConfig;
import ru.goryachev.foreman.config.WebConfig;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebConfig.class, ServiceConfig.class, JdbcConfigSample.class, DAOConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
