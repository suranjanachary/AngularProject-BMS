package com.suranjan.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suranjan.model.AdminSignupData;

@Repository
public interface AdminSignupDao extends JpaRepository<AdminSignupData, Integer> {
	
	 public Optional<AdminSignupData> findByUserName(String username);
}
