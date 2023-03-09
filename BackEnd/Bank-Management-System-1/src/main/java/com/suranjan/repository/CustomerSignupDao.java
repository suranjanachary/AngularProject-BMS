package com.suranjan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suranjan.model.CustomerSignup;

public interface CustomerSignupDao extends JpaRepository<CustomerSignup,Integer>
{
	public Optional<CustomerSignupDao> findByUserName(String username);
}
