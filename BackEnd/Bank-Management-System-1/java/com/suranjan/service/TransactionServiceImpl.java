package com.suranjan.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suranjan.exception.TransactionException;
import com.suranjan.model.Customer;
import com.suranjan.model.Transaction;
import com.suranjan.repository.CustomerDao;

@Service
public class TransactionServiceImpl implements TransactionService {

//	@Autowired
//	private TransactionDao transactionDao;
	
//	@Autowired
//	private AccountDao accountDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Transaction depositeAmount(Float amount, Integer accountNum) throws TransactionException {
		
	Customer accountDetail = customerDao.getCustomerByAcNo(accountNum);
		
	Customer customer = accountDetail;
	
	Transaction transaction= new Transaction();
	
	transaction.setTransaction_amount(amount);
		
	transaction.setRemaining_balance(transaction.getRemaining_balance() + amount);
	
	transaction.setTransaction_type("deposit");
	
	transaction.setTransaction_date(LocalDateTime.now());
	
	customer.getAllTrasactions().add(transaction);
	
	customerDao.save(customer);
	
	return transaction;
	}

	@Override
	public Transaction withdrawAmount(Float amount, Integer accountNum ) throws TransactionException {
		Optional<Customer> accountDetail = customerDao.findById(accountNum);
		
		Customer customer = accountDetail.get();
		
		Transaction transaction= new Transaction();
		
		transaction.setTransaction_amount(amount);
		
		if(transaction.getRemaining_balance() >= amount) {
			
			transaction.setRemaining_balance(transaction.getRemaining_balance() - amount);
		}
		
		System.out.println("Insufficient funds !!!");

		transaction.setTransaction_type("Withdraw");
		
		transaction.setTransaction_date(LocalDateTime.now());
		
		customer.getAllTrasactions().add(transaction);
		
		customerDao.save(customer);
		
		return transaction;
	}

	@Override
	public String availableAmount(Integer account_number) throws TransactionException {
		Transaction transaction= new Transaction();
		Float initBal= (float) 0;
		transaction.setRemaining_balance(initBal);
		
		Float avlBal = transaction.getRemaining_balance();
		String displayStat = "Your Available Balance is : "+ avlBal;
		return displayStat;
	}

}
