package ru.goryachev.foreman.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public DataSource dataSource;

    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/customlogin", "/registration").anonymous()
                //.antMatchers("/construction/**/materials").hasAnyRole("ADMIN", "CHIEF", "EMPLOYEE", "SUPPLIER")
                .antMatchers("/construction/orders").hasAnyRole("ADMIN", "CHIEF", "EMPLOYEE", "SUPPLIER")
                //.antMatchers("/constructions", "/construction/**").hasAnyRole("ADMIN", "CHIEF", "EMPLOYEE")
                //.antMatchers(HttpMethod.POST, "/construction/**/materials/**").hasAnyRole("ADMIN", "CHIEF")
                .antMatchers(HttpMethod.GET,"/constructions", "/construction/**").hasAnyRole("ADMIN", "CHIEF", "EMPLOYEE")
                .antMatchers(HttpMethod.POST, "/constructions", "/construction/**").hasAnyRole("ADMIN", "CHIEF")
                .antMatchers("/materials").hasAnyRole("ADMIN", "CHIEF", "EMPLOYEE")
                .antMatchers("/admin").hasAnyRole("ADMIN")
                .antMatchers("/**").hasAnyRole("ADMIN", "CHIEF")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/customlogin")
                .defaultSuccessUrl("/", true)
                .failureUrl("/customlogin?error=true")
                .and()
                .logout()
                .logoutSuccessUrl("/customlogin?logout=true")
                .invalidateHttpSession(true)
                .permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        //To get 3 fields from DB: user name (login), encrypted password, boolean (enabled) - enabled the user or not
        String userQuery = "SELECT login, password, 'true' FROM app_user WHERE login=?";

        //Also to get 2 fields from DB: user name (login), authorities; the values in database must be with "ROLE_", e.g. "ROLE_ADMIN"
        String autoritiesQuery = "SELECT au.login, r.rank FROM app_user au LEFT JOIN role r ON au.role_id=r.id WHERE login=?";

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(userQuery)
                .authoritiesByUsernameQuery(autoritiesQuery)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/sources/**");
    }


    @Bean
    protected PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder(12);
    }

}
