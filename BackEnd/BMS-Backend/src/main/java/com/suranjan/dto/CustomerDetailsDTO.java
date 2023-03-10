package com.suranjan.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerDetailsDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	private String customerName;
	
	private String customerEmail;
	
	private String customerPhone;

	private String customerAddress;
	
	private Integer accountNumber;
	
//	private Float accountBalance;
	
	private String accountDescription;
}
