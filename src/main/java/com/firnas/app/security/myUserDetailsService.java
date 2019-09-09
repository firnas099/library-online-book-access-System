package com.firnas.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.firnas.app.Dao.registrationRepo;
import com.firnas.app.enity.regitration;

@Service
public class myUserDetailsService implements UserDetailsService {

	@Autowired
	private registrationRepo registrationRepo;
	
	@Override
	public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
		
		regitration regitration =registrationRepo.findByEmail(Email);
		
		if(regitration == null)
			
			throw new UsernameNotFoundException("user 404");
		return new userPricipal(regitration);
	}

}
