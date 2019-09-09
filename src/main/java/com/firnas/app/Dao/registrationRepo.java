package com.firnas.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firnas.app.enity.regitration;

public interface registrationRepo extends JpaRepository<regitration, Integer> {

	
	regitration findByEmail(String Email);
}
