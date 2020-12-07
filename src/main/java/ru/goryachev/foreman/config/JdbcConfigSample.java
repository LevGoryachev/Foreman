package ru.goryachev.foreman.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/jdbc.properties")
public class JdbcConfigSample implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean

    public DataSource getDataSource () {

        String databaseUrl = env.getRequiredProperty("database.url");
        String username = env.getRequiredProperty("database.username");
        String password = env.getRequiredProperty("database.password");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }



}
