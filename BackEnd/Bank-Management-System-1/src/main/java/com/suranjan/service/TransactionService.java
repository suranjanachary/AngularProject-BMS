package com.suranjan.service;

import com.suranjan.exception.TransactionException;
import com.suranjan.model.Transaction;

public interface TransactionService {

	public Transaction depositeAmount (Float amount, Integer accountNum) throws TransactionException;
	public Transaction withdrawAmount (Float amount, Integer accountNum) throws TransactionException;
	public String availableAmount (Integer account_number) throws TransactionException;
}
