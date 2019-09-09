package com.firnas.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.firnas.app.enity.boockEntity;

public interface bookRepo extends JpaRepository<boockEntity, Integer> {

	

	

}
