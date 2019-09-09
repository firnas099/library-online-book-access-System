package com.firnas.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class appSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService UserDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(UserDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
		
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests()
//		.antMatchers("/bookshow").authenticated()
//		
//		.anyRequest().permitAll()
//		.and()
//		.csrf().disable();
//		http.httpBasic();
//		
//		
//		
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
	    .csrf().disable()
	      
	    .authorizeRequests()
	    .antMatchers("/bookshow").authenticated()

	    
	    
	    
	    
	    .anyRequest().permitAll()
	     .and()
	     
	    .formLogin()
	    .loginPage("/login").permitAll()
	    
	    .and()
	    .logout().invalidateHttpSession(true)
	    .clearAuthentication(true)
	    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	    .logoutSuccessUrl("/logout-sucess").permitAll();
	    
		
		
	}
	
	
	
}
