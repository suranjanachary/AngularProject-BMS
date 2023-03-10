package com.suranjan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suranjan.dto.AdminLoginDTO;

@Repository
public interface AdminLoginDTODao extends JpaRepository<AdminLoginDTO, Integer> {

}
