package ru.goryachev.foreman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.goryachev.foreman.dao.BillPositionDAO;
import ru.goryachev.foreman.dao.ConstructionsDAO;
import ru.goryachev.foreman.dao.DataAccessible;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class JdbcConfigSample implements WebMvcConfigurer {

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());

    }

    @Bean
    public DataSource getDataSource () {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

}
