package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String USERNAME_PWD_QUERY = "SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?";
	private static final String USERNAME_ROLES_QUERY = "SELECT ROLEID,ROLE,UNAME FROM USER_ROLES WHERE UNAME =?";
	@Autowired
	private DataSource ds;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds).usersByUsernameQuery(USERNAME_PWD_QUERY)
				.authoritiesByUsernameQuery(USERNAME_ROLES_QUERY);
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home.htm").access("permitAll").antMatchers("/wish.htm")
				.access("hasAnyRole('ROLE_ADMIN','ROLE_FACULTY')")
				.and().formLogin()
				.and().logout().logoutSuccessUrl("/home.htm")
				.and().exceptionHandling().accessDeniedPage("/error_page.jsp")
				.and().rememberMe()
				.and().sessionManagement().invalidSessionUrl("/timeout.jsp").maximumSessions(2).expiredUrl("/timeout.jsp");
	}

}
