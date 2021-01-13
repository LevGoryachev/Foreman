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
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
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

                .antMatchers("/constructions").hasAnyRole("ADMIN", "CHIEF", "EMPLOYEE")
                .antMatchers( "/constructions-editable").hasAnyRole("ADMIN", "CHIEF")
                .antMatchers( "/construction/**/materials-editable").hasAnyRole("ADMIN", "CHIEF")
                .antMatchers("/construction/**").hasAnyRole("ADMIN", "CHIEF", "EMPLOYEE")

                .antMatchers("/materials").hasAnyRole("ADMIN", "CHIEF", "EMPLOYEE")
                .antMatchers( "/materials-editable").hasAnyRole("ADMIN", "CHIEF")

                .antMatchers( "/supplier").hasAnyRole("ADMIN", "CHIEF", "SUPPLIER")
                .antMatchers(HttpMethod.POST, "/orders/**").hasAnyRole("ADMIN", "SUPPLIER")

                .antMatchers("/").hasAnyRole()
                .antMatchers("/admin").hasRole("ADMIN")

                .anyRequest().authenticated()
                .and().formLogin().loginPage("/customlogin")
                .defaultSuccessUrl("/", true)
                .successHandler(securityAuthHandler())
                .failureUrl("/customlogin?error=true")
                .and()
                .logout()
                .logoutSuccessUrl("/customlogin?logout=true")
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler());
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
    public AuthenticationSuccessHandler securityAuthHandler(){
        return new SecurityAuthHandler();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new SecurityDeniedHandler();
    }

    @Bean
    protected PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder(12);
    }
}
