package com.suranjan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suranjan.model.Transaction;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer> {

}
