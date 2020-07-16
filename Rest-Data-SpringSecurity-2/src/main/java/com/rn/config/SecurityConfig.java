package com.rn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AutheticationEntryPoint autheticationEntryPoint;

    @Autowired
    private DataSource ds;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(ds);
    }

    //@Override
    /*public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(ds)
                .withDefaultSchema()
                .withUser(
                        User.withUsername("Roshan")
                                .password("pass")
                                .roles("USER")
                )
                .withUser(
                        User.withUsername("Admin")
                                .password("pass")
                                .roles("ADMIN")
                );
    }*/





    //AUTHORIZATION SETUP
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
               .antMatchers("/getuser").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/","/myLogout").permitAll()
                .and().httpBasic().authenticationEntryPoint(autheticationEntryPoint);
    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
