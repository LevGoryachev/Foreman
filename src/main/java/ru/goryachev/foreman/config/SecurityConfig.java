package ru.goryachev.foreman.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/customlogin", "/registration").anonymous()
                    //.antMatchers("/construction/**/materials").hasAnyRole("ADMIN", "CHIEF", "EMPLOYEE", "SUPPLIER")
                    .antMatchers("/construction/orders").hasAnyRole("ADMIN", "CHIEF", "EMPLOYEE", "SUPPLIER")
                    .antMatchers("/constructions", "/construction/**").hasAnyRole("ADMIN", "CHIEF", "EMPLOYEE")
                    .antMatchers("/materials").hasAnyRole("ADMIN", "CHIEF", "EMPLOYEE")
                    .antMatchers("/**").hasAnyRole("ADMIN", "CHIEF")
                    //.antMatchers("/materials/**").hasAnyRole("ADMIN", "CHIEF")
                    //.antMatchers("/**").hasRole("ADMIN")
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
        auth.inMemoryAuthentication()
                    .withUser("admin")
                    .password("{noop}sys")
                    .authorities("ROLE_ADMIN")
                .and()
                    .withUser("chief")
                    .password("{noop}chief")
                    .authorities("ROLE_CHIEF")
                .and()
                    .withUser("employee")
                    .password("{noop}employee")
                    .authorities("ROLE_EMPLOYEE")
                .and()
                    .withUser("supplier")
                    .password("{noop}supplier")
                    .authorities("ROLE_SUPPLIER");
    }
/*
    @Bean
    protected UserDetailsService userDetailsService() {
        //return super.userDetailsService();
        return new InMemoryUserDetailsManager(
                User.builder()
                    .username("admin")
                    .password("{noop}admin")
                    .roles("admin")
                    .build()
        );
    }
*/

    protected PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder(12);
    }

}
