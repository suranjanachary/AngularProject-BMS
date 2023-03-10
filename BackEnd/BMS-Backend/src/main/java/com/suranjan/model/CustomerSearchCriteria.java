package com.suranjan.model;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomerSearchCriteria {
  
	@Autowired
	Customer customer = new Customer();
	
	public CustomerSearchCriteria() {
		// TODO Auto-generated constructor stub
	}

	public CustomerSearchCriteria(Customer customer) {
		super();
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerSearchCriteria [customer=" + customer + "]";
	}
	
	
	

	
	
}
