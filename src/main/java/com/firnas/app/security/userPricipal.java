package com.firnas.app.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.firnas.app.enity.regitration;

public class userPricipal implements UserDetails {

	
	
	private regitration regitration;
	
	
	
	
	
	
	public userPricipal(com.firnas.app.enity.regitration regitration) {
		super();
		this.regitration = regitration;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
		
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return regitration.getPass();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return regitration.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
