package com.suranjan.model;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomerSearchCriteria {
  
	private String customerName;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	} 
	
}
