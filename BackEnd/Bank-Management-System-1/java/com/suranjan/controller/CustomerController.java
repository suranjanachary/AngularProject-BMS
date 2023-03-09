package com.suranjan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suranjan.exception.TransactionException;
import com.suranjan.model.Transaction;
import com.suranjan.service.TransactionService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class CustomerController {
	
	@Autowired
	private TransactionService transactionService;

	@GetMapping("/get/balance/{accNo}")
	public ResponseEntity<String> getBalanceHandler (@PathVariable Integer accNo) throws TransactionException{
		
		String availBal = transactionService.availableAmount(accNo);
		
		return new ResponseEntity<String>(availBal,HttpStatus.OK);
	}
	
	@PutMapping("/deposite/{amt}/{accno}")
	public ResponseEntity<Transaction> depositeHandler (@PathVariable Float amt, @PathVariable Integer accno) throws TransactionException{
		
		Transaction deposited = transactionService.depositeAmount(amt, accno);
		
		return new ResponseEntity<Transaction>(deposited,HttpStatus.OK);
	}
	
	@PutMapping("/withdraw/{amt}/{accno}")
	public ResponseEntity<Transaction> withdrawHandler (@PathVariable Float amt, @PathVariable Integer accno) throws TransactionException{
		
		Transaction deposited = transactionService.depositeAmount(amt, accno);
		
		return new ResponseEntity<Transaction>(deposited,HttpStatus.OK);
	}
}
