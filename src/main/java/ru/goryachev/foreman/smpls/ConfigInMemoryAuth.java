package ru.goryachev.foreman.smpls;

public class ConfigInMemoryAuth {

    //classic JDBC connection is not used in this project, just for example
/*
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                    .withUser("admin")
                    .password("{noop}sys")
                    .roles("ADMIN")
                    //.authorities("ROLE_ADMIN")
                .and()
                    .withUser("chief")
                    .password("{noop}chief")
                    .roles("CHIEF")
                    //.authorities("ROLE_CHIEF")
                .and()
                    .withUser("employee")
                    .password("{noop}employee")
                    .roles("EMPLOYEE")
                    //.authorities("ROLE_EMPLOYEE")
                .and()
                    .withUser("supplier")
                    .password("{noop}supplier")
                    .roles("SUPPLIER");
                    //.authorities("ROLE_SUPPLIER");
    }

    protected PasswordEncoder passwordEncoder () {
        return NoOpPasswordEncoder.getInstance();
    }

*/
}
