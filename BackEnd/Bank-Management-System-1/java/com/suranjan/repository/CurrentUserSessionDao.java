package com.suranjan.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suranjan.model.CurrentUserSession;

public interface CurrentUserSessionDao extends JpaRepository<CurrentUserSession, Integer>{

    Optional<CurrentUserSession>  findByUserId(Integer userId);
	
	Optional<CurrentUserSession> findByUuid(String uuid);
}
