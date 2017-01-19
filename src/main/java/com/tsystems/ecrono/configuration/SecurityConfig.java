package com.tsystems.ecrono.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.tsystems.ecrono.repository.CreateUserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CreateUserRepository createUserRepository;

    @Autowired
    public SecurityConfig(CreateUserRepository createUserRepository) {
	super();
	this.createUserRepository = createUserRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(new MyUserDetailService(createUserRepository));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable()//
		.httpBasic().and()//
		.antMatcher("/**").authorizeRequests()//
		.antMatchers("/races/**/classification").hasAuthority("ANALYST")//
		.antMatchers(HttpMethod.GET, "/races/**").hasAuthority("PROGRAMER")//
		.antMatchers("/races/**").hasAuthority("ANALYST")//
		.antMatchers("/users/**").hasAuthority("GOOD")//
		.anyRequest().denyAll();
    }

}
