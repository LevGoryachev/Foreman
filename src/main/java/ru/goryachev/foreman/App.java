package ru.goryachev.foreman;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.goryachev.foreman.config.SpringConfig;
import ru.goryachev.foreman.service.PartBean;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        PartBean partBean = context.getBean(PartBean.class);

    }
}
