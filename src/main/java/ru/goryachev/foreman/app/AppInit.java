package ru.goryachev.foreman.app;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.goryachev.foreman.config.JdbcConfigTemplate;
import ru.goryachev.foreman.config.SpringConfig;
import ru.goryachev.foreman.config.WebConfig;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebConfig.class, SpringConfig.class, JdbcConfigTemplate.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
